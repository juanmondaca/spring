package cl.jotaeme.microservicios.app.servicio.beans;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class TiempoActualBean {
	
	public String tiempoActual() {
		return "El tiempo actual es :-> " + LocalDateTime.now();
	}

}
