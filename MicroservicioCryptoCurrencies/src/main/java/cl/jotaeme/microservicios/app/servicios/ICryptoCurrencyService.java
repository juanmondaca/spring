package cl.jotaeme.microservicios.app.servicios;

import cl.jotaeme.microservicios.app.util.WrapperCryptoAcronimo;
import cl.jotaeme.microservicios.app.util.WrapperCryptoCurrency;

public interface ICryptoCurrencyService {
	public WrapperCryptoCurrency todasLasCryptos();
	public WrapperCryptoAcronimo todosLosAcronimos();
	// obtiene las Top-N currency obtenidas por su price_USD
	public WrapperCryptoCurrency obtenerLasTopNCryptos(int topN);
}
