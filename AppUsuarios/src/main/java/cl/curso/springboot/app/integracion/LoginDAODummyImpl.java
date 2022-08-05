package cl.curso.springboot.app.integracion;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDAODummyImpl implements ILoginDAODummy {
	
	private String[] nombreUsuarios = {"usuario1","usuario2"};
	private String[] pwdUsuarios    = {"pwd1","pwd2"};
	

	@Override
	public boolean loginValido(String usua, String pwd) {
		// TODO Auto-generated method stub
		boolean res = false;
		for(int i = 0; i < 2; i++) {
			if(nombreUsuarios[i].equalsIgnoreCase(usua) && pwdUsuarios[i].equals(pwd)) {
				res = true;
				break;
			}
		}
		return res;
	}

}
