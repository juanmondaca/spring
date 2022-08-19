package cl.jotaeme.microservicios.app.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.jotaeme.microservicios.app.servicios.ICryptoCurrencyService;
import cl.jotaeme.microservicios.app.util.WrapperCryptoAcronimo;
import cl.jotaeme.microservicios.app.util.WrapperCryptoCurrency;

// llamara a esta AI desde la app Angular
@RestController
@RequestMapping("/api")
@CrossOrigin(value = "http://localhost:4200")
public class ApiCryptoCurrencies {
	
	@Autowired
	private ICryptoCurrencyService ccs;

	// Llama a API ubicadas en el servicio REST "http://ejemplo-cryptomonedas.herokuapp.com" 
	// @CrossOrigin(value = "http://localhost:4200")
	@GetMapping(value = "/listaCryptos")
	public WrapperCryptoCurrency todasLasCryptos() {
		return this.ccs.todasLasCryptos();
	}
	
	// @CrossOrigin(value = "http://localhost:4200")
	@GetMapping(value = "/listaAcronimos")
	public WrapperCryptoAcronimo todosLosAcronimos() {
		return this.ccs.todosLosAcronimos();
	}
	// obtiene las n cryptocurrencies ordenadas de mayor a menor
	@PostMapping(value = "/top/{n}")
	public WrapperCryptoCurrency topNCryptos(@PathVariable("n") int topn) {
		return this.ccs.obtenerLasTopNCryptos(topn);
	}
	
	
}
