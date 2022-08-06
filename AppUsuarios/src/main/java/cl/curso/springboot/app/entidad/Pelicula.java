package cl.curso.springboot.app.entidad;

import javax.persistence.*;

@Entity
@Table(name="pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue()
	private Long idPelicula;
	@Column(name="nombrePelicula")
	private String nombrePelicula;

	private String generoPelicula;
	private String directorPelicula;
	
	
	public Long getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(Long idPelicula) {
		this.idPelicula = idPelicula;
	}
	public String getNombrePelicula() {
		return nombrePelicula;
	}
	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}
	public String getGeneroPelicula() {
		return generoPelicula;
	}
	public void setGeneroPelicula(String generoPelicula) {
		this.generoPelicula = generoPelicula;
	}
	public String getDirectorPelicula() {
		return directorPelicula;
	}
	public void setDirectorPelicula(String directorPelicula) {
		this.directorPelicula = directorPelicula;
	};
	
	

}
