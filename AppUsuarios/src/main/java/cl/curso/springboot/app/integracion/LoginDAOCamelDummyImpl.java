package cl.curso.springboot.app.integracion;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

//import cl.curso.springboot.app.integracion.ILoginDAODummy;

@Repository
public class LoginDAOCamelDummyImpl implements ILoginDAODummy {
	
	// autentifica a un usuario usando un microservicio con Apache Camel
	// El microservicio es:-> Camel-microservicio-1
	
	// validacion del login usando un microservicio SpringBoot
	public boolean loginValido(String usua, String pwd) {
		boolean respuestaApi = false;

		String urlApi = "http://localhost:8080/api-camel-auth";
		
		RestTemplate rt = new RestTemplate();
		
		respuestaApi = rt.postForObject(urlApi + "/validar/"+ usua.trim() + "/" 
		+ pwd.trim(),null , Boolean.class);
		
		
		return respuestaApi;
	}

}
