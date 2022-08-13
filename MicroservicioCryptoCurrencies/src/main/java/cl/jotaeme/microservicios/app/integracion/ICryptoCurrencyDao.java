package cl.jotaeme.microservicios.app.integracion;

import java.util.List;

import cl.jotaeme.microservicios.app.util.WrapperCryptoAcronimo;
import cl.jotaeme.microservicios.app.util.WrapperCryptoCurrency;

public interface ICryptoCurrencyDao {
	public WrapperCryptoCurrency todasLasCryptos();
	public WrapperCryptoAcronimo todosLosAcronimos();
	public WrapperCryptoCurrency obtenerLasTopNCryptos(int topN);
	// selecciona una lista de cryptos y las retorna ordenadas en forma decreciente
	// el parametro acronimosSelecciondos son acronimos de las cryptos
	public WrapperCryptoCurrency seleccionNCryptos(List<String> acronimosSeleccionados);
}
