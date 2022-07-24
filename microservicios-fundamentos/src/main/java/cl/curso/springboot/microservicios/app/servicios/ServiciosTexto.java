package cl.curso.springboot.microservicios.app.servicios;

import org.springframework.stereotype.Service;

@Service
public class ServiciosTexto {
	
	public String textoMasLargo(String s1, String s2) {
		
		return s1.trim().length() >= s2.trim().length() ? s1 : s2 ;
	}

}
