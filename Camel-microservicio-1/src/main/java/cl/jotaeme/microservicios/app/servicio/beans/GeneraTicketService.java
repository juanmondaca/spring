package cl.jotaeme.microservicios.app.servicio.beans;

import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.ExchangeProperties;
import org.apache.camel.Headers;
import org.springframework.stereotype.Service;

@Service
public class GeneraTicketService {

	// genera un ticket dummy si el usuario se a autenficado correctamente
	public String muestraInformacion(@Body String bodyMensaje,
			@Headers Map<String, String> headersMensaje,
			@ExchangeProperties Map<String, String> exchangePropertiesMensaje) {
		
			String infoBody = "body :-> " + bodyMensaje;
			String infoKeyHeaders = "";
			for(String sk : headersMensaje.keySet()) {
				infoKeyHeaders += sk;
			}
			infoKeyHeaders = "headers :-> " + infoKeyHeaders;
			String infoExchange = "";
			for(String se : exchangePropertiesMensaje.keySet()) {
				infoExchange += se;
			}
			infoExchange = "exchangeProperties :-> " + infoExchange;
		
		return infoBody + " - " + infoKeyHeaders + " - " + infoExchange;
	}
	
	public String nuevoTicket() {
		return "";
	}
	
}
