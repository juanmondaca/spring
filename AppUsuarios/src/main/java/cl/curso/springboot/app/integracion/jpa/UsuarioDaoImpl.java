package cl.curso.springboot.app.integracion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cl.curso.springboot.app.entidad.Usuario;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Usuario> listar() {
		return this.em.createQuery("from Usuario").getResultList();
	}

	@Override
	@Transactional
	public void grabar(Usuario u) {
		if(u.getId() != null && u.getId() > 0) {
			// Caso en que la entidad ya existe => actualiza con merge
			this.em.merge(u);
		}else {
			// caso que entidad no existe => inserta con persist
			this.em.persist(u);
		}
		
	}

	@Override
	public Usuario encontrarUsuario(Long idUsuario) {
		return this.em.find(Usuario.class, idUsuario);
	}

	@Override
	public void borrarUsuario(Long idUsuario) {
		this.em.remove(idUsuario);
	}

}
