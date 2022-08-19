package cl.jotaeme.microservicios.app.servicios;

import java.util.List;

import cl.jotaeme.microservicios.app.util.WrapperCryptoAcronimo;
import cl.jotaeme.microservicios.app.util.WrapperCryptoCurrency;

public interface ICryptoCurrencyService {
	public WrapperCryptoCurrency todasLasCryptos();
	public WrapperCryptoAcronimo todosLosAcronimos();
	// obtiene las Top-N currency obtenidas por su price_USD de manera decreciente
	public WrapperCryptoCurrency obtenerLasTopNCryptos(int topN);
	// obtiene un subcjto de las currencies determindo por la lista acronimosSeleccionados
	// se retorna ordenada en forma decreciente
	public WrapperCryptoCurrency seleccionNCryptos(List<String> acronimosSeleccionados);
}
