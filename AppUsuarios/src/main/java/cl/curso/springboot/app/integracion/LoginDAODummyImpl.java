package cl.curso.springboot.app.integracion;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class LoginDAODummyImpl implements ILoginDAODummy {
	
//	private String[] nombreUsuarios = {"usuario1","usuario2"};
//	private String[] pwdUsuarios    = {"pwd1","pwd2"};
	

//	@Override
//	public boolean loginValido(String usua, String pwd) {
//		// TODO Auto-generated method stub
//		boolean res = false;
//		for(int i = 0; i < 2; i++) {
//			if(nombreUsuarios[i].equalsIgnoreCase(usua) && pwdUsuarios[i].equals(pwd)) {
//				res = true;
//				break;
//			}
//		}
//		return res;
//	}
	
	// validacion del login usando un microservicio SpringBoot
	public boolean loginValido(String usua, String pwd) {
		boolean respuestaApi = false;
		
		//String urlApi = "http://localhost:8083/api/login/";
		String urlApi = "http://localhost:8083/api-auth/login/";
		
		RestTemplate rt = new RestTemplate();
		
		respuestaApi = rt.postForObject(urlApi + usua.trim() + "/" 
		+ pwd.trim(),null , Boolean.class);
		
		
		return respuestaApi;
	}

}
