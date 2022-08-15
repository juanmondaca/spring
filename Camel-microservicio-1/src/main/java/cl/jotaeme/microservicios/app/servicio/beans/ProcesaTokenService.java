package cl.jotaeme.microservicios.app.servicio.beans;

import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.springframework.stereotype.Service;

@Service
public class ProcesaTokenService {

	
	public boolean validaToken(@Body String bodyMensaje,
			@Headers Map<String, String> headersMensaje,
			@ExchangeProperties Map<String, String> exchangePropertiesMensaje) {
		
		boolean exitoAuth =  false;
		
		if(!bodyMensaje.trim().isEmpty() && bodyMensaje.trim().contains("_AUTH_OK")) {
			// auth correcta
			exitoAuth = true;
		}
		
		return exitoAuth ; //!bodyMensaje.trim().isEmpty() ? bodyMensaje.trim().concat("_VALIDO"):"NO_HAY_TOKEN";
	}
	
}
