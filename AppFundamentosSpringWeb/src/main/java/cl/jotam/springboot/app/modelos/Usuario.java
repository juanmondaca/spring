package cl.jotam.springboot.app.modelos;

public class Usuario {
	
	private String nombre;
	private String apelliido;
	private String email;
	
	public Usuario() {
		
	}
	
	public Usuario(String nombre, String apellido, String email) {
		this.nombre    = nombre;
		this.apelliido = apellido;
		this.email     = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApelliido() {
		return apelliido;
	}
	public void setApelliido(String apelliido) {
		this.apelliido = apelliido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
