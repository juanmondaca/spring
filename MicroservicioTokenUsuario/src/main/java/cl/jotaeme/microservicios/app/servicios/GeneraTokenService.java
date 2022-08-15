package cl.jotaeme.microservicios.app.servicios;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class GeneraTokenService {

	// genera un token dummy si el usuario se a autenficado correctamente o no
	public String nuevoTicket(String nombreUsuario, String status) {
		String tokenUsuario = null;
		// status posibles: USUARIO_AUTORIZADO USUARIO_NO_AUTORIZADO
		if(status.trim().toUpperCase().equals("USUARIO_AUTORIZADO"))
		{
			LocalDateTime fechaActual = LocalDateTime.now();
			int nanoActual = LocalDateTime.now().getNano();
			
			tokenUsuario = nombreUsuario + String.valueOf(fechaActual) + String.valueOf(nanoActual) + "_AUTH_OK";
		}else {
			tokenUsuario = nombreUsuario + "_" + status.toUpperCase() + "_AUTH_NOK";
		}
		
		return tokenUsuario;
	}
}
