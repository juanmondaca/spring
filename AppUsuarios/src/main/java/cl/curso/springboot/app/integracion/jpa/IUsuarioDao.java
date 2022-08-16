package cl.curso.springboot.app.integracion.jpa;

import java.util.List;

import cl.curso.springboot.app.entidad.Usuario;

public interface IUsuarioDao {

	public List<Usuario> listar();
	
	public void grabar(Usuario u);
	
	public Usuario encontrarUsuario(Long idUsuario);
	
	public void borrarUsuario(Long idUsuario);
}
