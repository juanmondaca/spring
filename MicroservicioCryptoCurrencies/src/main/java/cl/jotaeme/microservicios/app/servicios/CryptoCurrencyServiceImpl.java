package cl.jotaeme.microservicios.app.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.jotaeme.microservicios.app.entidad.CryptoCurrency;
import cl.jotaeme.microservicios.app.integracion.ICryptoCurrencyDao;
import cl.jotaeme.microservicios.app.util.WrapperCryptoAcronimo;
import cl.jotaeme.microservicios.app.util.WrapperCryptoCurrency;

@Service
public class CryptoCurrencyServiceImpl implements ICryptoCurrencyService {
	@Autowired
	private ICryptoCurrencyDao ccd;

	@Override
	public WrapperCryptoCurrency todasLasCryptos() {
		// TODO Auto-generated method stub
		return this.ccd.todasLasCryptos();
	}

	@Override
	public WrapperCryptoAcronimo todosLosAcronimos() {
		// TODO Auto-generated method stub
		return this.ccd.todosLosAcronimos();
	}

	@Override
	public WrapperCryptoCurrency obtenerLasTopNCryptos(int topN) {
		return this.ccd.obtenerLasTopNCryptos(topN);
	}

	@Override
	public WrapperCryptoCurrency seleccionNCryptos(List<String> acronimosSeleccionados) {
		// TODO Auto-generated method stub
		return this.ccd.seleccionNCryptos(acronimosSeleccionados);
	}
	
	

}
