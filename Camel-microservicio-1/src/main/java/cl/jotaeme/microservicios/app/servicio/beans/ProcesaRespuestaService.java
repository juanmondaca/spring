package cl.jotaeme.microservicios.app.servicio.beans;

import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.springframework.stereotype.Service;

@Service
public class ProcesaRespuestaService {
	
	public String procesaRespuesta(@Body String bodyMensaje,
			@Headers Map<String, String> headersMensaje,
			@ExchangeProperties Map<String, String> exchangePropertiesMensaje) {
		
		final String STATUS_NO_AUTH = "USUARIO_NO_AUTORIZADO";
		final String STATUS_AUTH    = "USUARIO_AUTORIZADO";
		
		String resp = STATUS_NO_AUTH;
		if(bodyMensaje.trim().equalsIgnoreCase("true")) {
			resp = STATUS_AUTH;
		}
		
		return resp;
	}

}
