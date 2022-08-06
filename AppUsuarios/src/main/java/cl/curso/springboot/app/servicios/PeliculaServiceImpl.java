package cl.curso.springboot.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.curso.springboot.app.entidad.Pelicula;
import cl.curso.springboot.app.integracion.jpa.IPeliculaDAO;
import cl.curso.springboot.app.integracion.jpa.IPeliculaDaoCrud;
@Service
public class PeliculaServiceImpl implements IPeliculaService{
	// CASO 1. Primero probar con la interfaz IPeliculaDAO
	@Autowired
	private IPeliculaDAO peliculaDao;
	
	// CASO 2. Segundo probar con la interfazz IPeliculaDaoCrud
//	@Autowired
//	private IPeliculaDaoCrud peliculaDao;

	@Override
	public List<Pelicula> findAll() {
		// TODO Auto-generated method stub
		// 1. Para CASO 1
		//return this.peliculaDao.findAll();
		// 2. Para CASO 2.
		return (List<Pelicula>) this.peliculaDao.findAll();
	}

	@Override
	public void save(Pelicula pelicula) {
		// Primero verifica si la pelicual ya existe
//		Pelicula pel = this.findOne(pelicula.getIdPelicula());
//		if(pel != null) {
//			this.peliculaDao.save(pel);
//			return;
//		}
		this.peliculaDao.save(pelicula);
	}

	@Override
	public Pelicula findOne(Long id) {
		// 1. Para CASO 1
		return this.peliculaDao.findOne(id);
		// 2. Para CASO 2
//		return this.peliculaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// 1. Para CASO 1
		 this.peliculaDao.delete(id);
		// 2. Para CASO 2
//		this.peliculaDao.deleteById(id);
	}

}
