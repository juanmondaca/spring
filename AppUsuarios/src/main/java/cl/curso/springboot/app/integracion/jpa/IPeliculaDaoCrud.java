package cl.curso.springboot.app.integracion.jpa;

import org.springframework.data.repository.CrudRepository;

import cl.curso.springboot.app.entidad.Pelicula;

public interface IPeliculaDaoCrud extends CrudRepository<Pelicula, Long> {

}
