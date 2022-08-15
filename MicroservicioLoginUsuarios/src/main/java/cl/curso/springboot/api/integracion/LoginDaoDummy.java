package cl.curso.springboot.api.integracion;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoDummy implements ILoginDaoDummy {
	// Valida las credenciales de un usuario con datos fijos
	private String[] nombresUsuarios = {"usuario1","usuario2"};
	private String[] pwdUsuarios     = {"pwd1","pwd2"};	
	@Override
	public boolean loginValido(String usua, String pwd) {
		boolean respuesta = false;		
		for(int i = 0; i < 2;i++) {
			if(nombresUsuarios[i].equalsIgnoreCase(usua) && 
					pwdUsuarios[i].equals(pwd)) {
				respuesta = true;
				break;
			}
		}	
		return respuesta;
	}
	

}
