package cl.curso.springboot.app.servicios;
// interfaz para el servicio de Login
public interface ILoginService {
	// metodo para validar las credenciales enviadas por un usuario
	public boolean validaCredenciales(String u, String p);

}
