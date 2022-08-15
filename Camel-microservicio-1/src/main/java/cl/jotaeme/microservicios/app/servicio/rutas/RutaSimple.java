package cl.jotaeme.microservicios.app.servicio.rutas;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.jotaeme.microservicios.app.servicio.beans.TiempoActualBean;

//@Component
public class RutaSimple extends RouteBuilder {

	@Autowired
	private TiempoActualBean tActual;
	
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer:timer-uno?period=5000")
		.id("ruta-1")
		//.transform().constant("Tiempo actual: " + LocalDateTime.now())
		.bean(tActual,"tiempoActual")
		.log("${body}")
		.to("log:log-timer-uno");
	}

}
