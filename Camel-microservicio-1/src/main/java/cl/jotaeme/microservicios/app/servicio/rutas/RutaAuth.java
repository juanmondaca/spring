package cl.jotaeme.microservicios.app.servicio.rutas;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestConfigurationDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jotaeme.microservicios.app.servicio.beans.ProcesaTokenService;
import cl.jotaeme.microservicios.app.servicio.beans.ProcesaRespuestaService;

// ruta que llama a un microservicio MicroservicioLoginUsuarios
@Service
public class RutaAuth extends RouteBuilder {

	// Configurar las rutas para llamar a microservicios externos
	// operaciones tipicas en una ruta:
	// 1. endpoint: el nombre de una ruta posible a llamar
	// 2. recibir un input
	// 3. transformaciones del mensaje
	// 4. enviar el mensaje transformado a un destino

	// para escribir la ruta se puede con:
	// 1. DSL de java
	// 2. XML

	@Autowired
	ProcesaRespuestaService prs;
	
	@Override
	public void configure() throws Exception {
		
		restConfiguration().host("localhost").port(8083);
		// uri de la api MicroservicioTokenUsuario
		
		from("direct:llamada-api-auth-usuarios")
		.id("ruta_auth_usuarios")
		.log("mensaje antes de llamar a la api, BODY :->  + ${body} + , HEADERS :-> ${headers}")
//		.setHeader("nombre", () -> "usuario1")
//		.setHeader("pwd", () -> "pwd1")
		.to("rest:post:/api-auth/login/{nombre}/{pwd}")
		.log("mensaje despues de llamar a la api, BODY :->  + ${body} + , HEADERS :-> ${headers}")
//		.transform().body(String.class)
//		.choice()
//			.when(simple("${body} contains 'true'"))
//				.log("Credenciales del usuario son coreectas !")
//				.bean(this.gtc,"muestraInformacion")
//			.otherwise()
//				.log("Credenciales del usuario son INcorrectas !")
		//.log("mensaje luego de llamar a la api :-> + ${body}")
		// utiliza el servicio ProcesaRespuesta para determinar la ruta a seguir
		.bean(this.prs,"procesaRespuesta")
		.transform().body(String.class)
		.to("direct:genera-token-usuario")
		
		.end();
		/*  Esta parte es cuando generamos el token aca.
		 *  Luego se cambiara cuando el token se genera 
		 *  en otro microservicio
		 * 
		 * */
//		.choice()
//			.when(simple("${body} == 'USUARIO_AUTORIZADO'"))
//				// si el usuario se auth correctamente entonces se muestra en el log
//				// y se crea un ticket con el servicio generaTicket
//				.log("Credenciales del usuario son correctas ! :-> + ${body}")
//				.to("direct:ruta-genera-token-usuario-auth")
//			.otherwise()
//				.log("Credenciales del usuario son INcorrectas ! :-> + ${body}")
//				.to("direct:ruta-genera-token-usuario-no-auth")
//		.end();
//		
//		// ruta para crear el ticket a un usuario autentificado
//		
//		from("direct:ruta-genera-token-usuario-auth")
//		.id("ruta_token_usuarios_auth")
//		.log("mensaje antes de generar Token, BODY :->  + ${body} + , HEADERS :-> ${headers}")
//		.bean(this.gtc,"nuevoTicket")
//		.log("mensaje Token generado, BODY :->  + ${body} + , HEADERS :-> ${headers}")
//		.end();
//		
//		// ruta para crear el token de un usuario no autentificado
//		
//		from("direct:ruta-genera-token-usuario-no-auth")
//		.id("ruta_token_usuarios_no_auth")
//		.bean(this.gtc,"tokenUsuarioInvalido")
//		.log("mensaje Token generado, BODY :->  + ${body} + , HEADERS :-> ${headers}")
//		.end();
		
	}

}
