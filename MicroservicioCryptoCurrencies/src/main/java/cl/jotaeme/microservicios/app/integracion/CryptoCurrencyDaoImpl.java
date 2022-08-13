package cl.jotaeme.microservicios.app.integracion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import cl.jotaeme.microservicios.app.entidad.CryptoAcronimo;
import cl.jotaeme.microservicios.app.entidad.CryptoCurrency;
import cl.jotaeme.microservicios.app.util.WrapperCryptoAcronimo;
import cl.jotaeme.microservicios.app.util.WrapperCryptoCurrency;

@Repository
public class CryptoCurrencyDaoImpl implements ICryptoCurrencyDao{

	private String urlBase = "http://ejemplo-cryptomonedas.herokuapp.com/api";
	private Gson gs = new Gson();
	
	@Override
	public WrapperCryptoCurrency todasLasCryptos() {
		WrapperCryptoCurrency wcc = new WrapperCryptoCurrency();
		wcc.setListaCC(this.apiListado());
		return wcc;
	}

	@Override
	public WrapperCryptoAcronimo todosLosAcronimos() {
		WrapperCryptoAcronimo wca = new WrapperCryptoAcronimo();
		wca.setListaCA(this.apiAcronimos());
		return wca;
	}
	
	@Override
	public WrapperCryptoCurrency obtenerLasTopNCryptos(int topN) {
		WrapperCryptoCurrency wcc = new WrapperCryptoCurrency();
		List<CryptoCurrency> listaCompleta = this.apiListado();
		// ordenar de manera decreciente la lista
		listaCompleta.sort(Comparator.comparing(CryptoCurrency::getPrice_USD).reversed());
		wcc.setListaCC(listaCompleta.subList(0, topN));
		return wcc;
	}
	
	@Override
	public WrapperCryptoCurrency seleccionNCryptos(List<String> acronimosSeleccionados) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// metodos privados
	private String creaTemplateRest(String uri) {
		String uriApiRest = this.urlBase + uri;
		RestTemplate rt = new RestTemplate();
		String resultadoLlamada = rt.getForObject(uriApiRest, String.class);
		
		return resultadoLlamada;
	}
	// Llama a la APi /api/lcm
	private List<CryptoCurrency> apiListado(){

		String resultadoLlamada = this.creaTemplateRest("/lcm");
		
		CryptoCurrency[] arrayCc = this.gs.fromJson(resultadoLlamada,CryptoCurrency[].class);
		return Arrays.asList(arrayCc);
	}
	// Llama a la APi /api/la
	private List<CryptoAcronimo> apiAcronimos(){

		String resultadoLlamada = this.creaTemplateRest("/la");
		
		CryptoAcronimo[] arrayCa = this.gs.fromJson(resultadoLlamada,CryptoAcronimo[].class);
		return Arrays.asList(arrayCa);
	}

}
