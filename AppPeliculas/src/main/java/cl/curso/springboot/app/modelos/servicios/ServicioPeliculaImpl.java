package cl.curso.springboot.app.modelos.servicios;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.curso.springboot.app.modelos.daoDummy.IDaoDummy;
import cl.curso.springboot.app.modelos.entidades.Pelicula;

@Service
public class ServicioPeliculaImpl implements IServicioPelicula{
	
	@Autowired
	private IDaoDummy daoDummy;

	@Override
	@Transactional(readOnly = true)
	public List<Pelicula> listarTodas() {
		// TODO Auto-generated method stub
		return daoDummy.listarTodas();
	}

	@Override
	@Transactional()
	public void agregarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		daoDummy.agregarPelicula(pelicula);
	}

}
