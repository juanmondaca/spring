package cl.jotaeme.microservicios.app.servicio.beans;

import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.springframework.stereotype.Service;

@Service
public class ProcesaRespuestaService {
	
	public boolean procesaRespuesta(@Body String bodyMensaje,
			@Headers Map<String, String> headersMensaje,
			@ExchangeProperties Map<String, String> exchangePropertiesMensaje) {
		
		boolean resp = false;
		if(bodyMensaje.trim().equalsIgnoreCase("true")) {
			resp = true;
		}
		
		return resp;
	}

}
