package cl.curso.springboot.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.curso.springboot.app.entidad.Usuario;
import cl.curso.springboot.app.integracion.jpa.IUsuarioDao;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	@Autowired
	private IUsuarioDao ud;
	@Override
	public List<Usuario> listar() {
		return this.ud.listar();
	}

	@Override
	public void grabar(Usuario u) {
		this.ud.grabar(u);
	}

	@Override
	public Usuario encontrarUsuario(Long idUsuario) {

		return this.ud.encontrarUsuario(idUsuario);
	}

	@Override
	public void borrarUsuario(Long idUsuario) {
		this.ud.borrarUsuario(idUsuario);

	}

}
