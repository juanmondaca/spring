package cl.curso.springboot.app.integracion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.curso.springboot.app.entidad.Pelicula;

@Repository
public class PeliculaDAOImpl implements IPeliculaDAO{
	
	//Contexto de persistencia 
	@PersistenceContext
	private EntityManager em;
	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> findAll() {
		return em.createQuery("from Pelicula").getResultList();
	}
	@Override
	@Transactional
	public void save(Pelicula pelicula) {
		if(pelicula.getIdPelicula() != null && pelicula.getIdPelicula() > 0) {
			// Caso en que el id ya existe => actualiza con merge
			em.merge(pelicula);
		}else {
			// caso que el id NO exista => inserta el nuevo registro con persist
			em.persist(pelicula);
		}
		
	}
	@Override
	public Pelicula findOne(Long id) {
		// TODO Auto-generated method stub
		return em.find(Pelicula.class, id);
	}
	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		em.remove(findOne(id));
	}

}
