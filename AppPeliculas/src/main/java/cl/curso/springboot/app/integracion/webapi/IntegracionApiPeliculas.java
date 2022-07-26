package cl.curso.springboot.app.integracion.webapi;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cl.curso.springboot.app.modelos.entidades.Pelicula;
import cl.curso.springboot.app.modelos.wrappers.WraperListaPeliculas;

@Component
public class IntegracionApiPeliculas {
	
	private String uriBaseApiRest = "http://localhost:8080/api/peliculas";
	
	public List<Pelicula> listarApiPeliculas(){
		
		RestTemplate rt = new RestTemplate();
		//@SuppressWarnings("unchecked")
		//List<Pelicula> listaReturn = rt.getForObject(this.uriBaseApiRest, );
		System.out.println("Antes del WraperListaPeliculas");
		WraperListaPeliculas listaReturn = rt.getForObject(uriBaseApiRest + "/listar", WraperListaPeliculas.class);
		System.out.println("WraperListaPeliculas :-> " + listaReturn.getListaPeliculas());
		return listaReturn.getListaPeliculas();
	}

}
