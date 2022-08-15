package cl.jotaeme.microservicios.app.servicio.rutas;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestConfigurationDefinition;
import org.apache.camel.spi.RestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jotaeme.microservicios.app.servicio.beans.ProcesaRespuestaService;
import cl.jotaeme.microservicios.app.servicio.beans.ProcesaTokenService;

// servicio a cargo de generar los tokens
@Service
public class RutaToken extends RouteBuilder {
	@Autowired
	private ProcesaTokenService gts;
//	@Autowired
//	private ProcesaRespuestaService prs;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		/*
		 * Esta ruta recibe si el usuario esta o no autorizado.
		 * Y con esta info llama al microservicio: MicroservicioTokenUsuario
		 * el que responde con el token adecuado.
		 * Este token debe ser devuelto al microservicio: Camel-microsevicio-1
		 * */
		// uri de la api MicroservicioTokenUsuario
		// en este caso 
		//restConfiguration().host("localhost").port(8084);
		
		from("direct:genera-token-usuario")
		.id("ruta-genera-token-usuario")
		.log("En ruta-genera-token-usuario Status :-> ${body} , NombreUsuario :-> ${headers.nombre}")
		// llama al microservicio MicroservicioTokenUsuario
		// en ${body} viene el status y en ${headers.nombre} viene el nombre del usuario
		// ambos datos son necasarios para crear el token
		.setHeader("nombreusuario", () -> "${headers.nombre}")
		.setHeader("statususuario", () -> "${body}")
		//.to("rest:post:/api-token/crear/{nombreusuario}/{statususuario}")
		.toD("http:localhost:8084/api-token/crear/${headers.nombre}/${body}")
		.log("En ruta-genera-token-usuario Respuesta desde MicroservicioTokenUsuario  BODY :-> ${body} , HEADERS :-> ${headers}")
		.bean(this.gts,"validaToken")
		.end();
		
	}

}
