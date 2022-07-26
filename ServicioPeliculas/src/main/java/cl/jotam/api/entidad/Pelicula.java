package cl.jotam.api.entidad;

import java.io.Serializable;

public class Pelicula implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idPelicula;
	private String nombrePelicula;
	private String generoPelicula;
	private String directorPelicula;
	
	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pelicula(int idPelicula, String nombrePelicula, String generoPelicula, String directorPelicula) {
		super();
		this.idPelicula = idPelicula;
		this.nombrePelicula = nombrePelicula;
		this.generoPelicula = generoPelicula;
		this.directorPelicula = directorPelicula;
	}
	public int getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(int idPelicula) {
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
	}
	
	

}
