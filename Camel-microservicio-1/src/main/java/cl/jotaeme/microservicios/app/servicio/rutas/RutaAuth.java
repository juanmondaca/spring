package cl.jotaeme.microservicios.app.servicio.rutas;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jotaeme.microservicios.app.servicio.beans.GeneraTicketService;
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
	GeneraTicketService gtc;
	@Autowired
	ProcesaRespuestaService prs;
	
	@Override
	public void configure() throws Exception {
		
		restConfiguration().host("localhost").port(8083);
		
		from("direct:llamada-api-auth-usuarios")
		.log("mensaje antes de llamar a la api :->  + ${body}")
//		.setHeader("nombre", () -> "usuario1")
//		.setHeader("pwd", () -> "pwd1")
		.to("rest:post:/api-auth/login/{nombre}/{pwd}")
		
//		.transform().body(String.class)
//		.choice()
//			.when(simple("${body} contains 'true'"))
//				.log("Credenciales del usuario son coreectas !")
//				.bean(this.gtc,"muestraInformacion")
//			.otherwise()
//				.log("Credenciales del usuario son INcorrectas !")
		//.log("mensaje luego de llamar a la api :-> + ${body}")
		.bean(this.prs,"procesaRespuesta")
		.choice()
			.when(simple("${body}"))
				.log("Credenciales del usuario son coreectas !")
			.otherwise()
				.log("Credenciales del usuario son INcorrectas !")
		.end();
	}

}
