package cl.jotaeme.microservicios.app.integracion;

import java.util.List;

import cl.jotaeme.microservicios.app.util.WrapperCryptoAcronimo;
import cl.jotaeme.microservicios.app.util.WrapperCryptoCurrency;

public interface ICryptoCurrencyDao {
	public WrapperCryptoCurrency todasLasCryptos();
	public WrapperCryptoAcronimo todosLosAcronimos();
	public WrapperCryptoCurrency obtenerLasTopNCryptos(int topN);

	public WrapperCryptoCurrency seleccionNCryptos(List<String> acronimosSeleccionados);
}
