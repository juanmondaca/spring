package cl.curso.springboot.app.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.curso.springboot.app.integracion.ILoginDAODummy;

// servicio de operaciones de Login

@Service
public class LoginServiceImpl implements ILoginService {
	
	// en un primer caso las credenciales son fijas
//	private String nombreUsuario = "usuario1";;
//	private String pwdUsuario    = "Pwd1";
	
	// en un segundo caso usamos el repositorio
	@Autowired
	@Qualifier("loginDAOCamelDummyImpl") // esta anotacion usarla solo con la auth via microservicio Camel
	private ILoginDAODummy ldd;

	@Override
	public boolean validaCredenciales(String u, String p) {
		// TODO Auto-generated method stub
		boolean resp = false;
		//1. caso:: Sin repositorio
//		if(u.trim().equalsIgnoreCase(nombreUsuario) && p.trim().equals(pwdUsuario)) {
//			resp = true;
//		}
		//2. caso::: CON repositorio (se debe inyetar primero en la clase)
		
		if(ldd.loginValido(u, p)) {
			resp = true;
		}
		
		
		
		return resp;
	}

}
