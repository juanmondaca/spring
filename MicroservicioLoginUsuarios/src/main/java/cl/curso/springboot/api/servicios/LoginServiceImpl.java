package cl.curso.springboot.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.curso.springboot.api.integracion.ILoginDaoDummy;
@Service
public class LoginServiceImpl implements ILoginService {
	// Inyectar un componete de tipo repositorio LoginDaoDummy
	@Autowired
	private ILoginDaoDummy ldd;	
	@Override
	public boolean validaCredenciales(String nu, String pu) {
		// agregar validaciones sobre los parametros
		return this.ldd.loginValido(nu, pu);
	}

}
