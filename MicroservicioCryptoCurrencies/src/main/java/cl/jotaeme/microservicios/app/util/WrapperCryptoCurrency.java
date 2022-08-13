package cl.jotaeme.microservicios.app.util;

import java.util.ArrayList;
import java.util.List;

import cl.jotaeme.microservicios.app.entidad.CryptoCurrency;

public class WrapperCryptoCurrency {

	private List<CryptoCurrency> listaCC ;
	
	public WrapperCryptoCurrency() {
		this.listaCC = new ArrayList<>();
	}

	public List<CryptoCurrency> getListaCC() {
		return listaCC;
	}

	public void setListaCC(List<CryptoCurrency> listaCC) {
		this.listaCC = listaCC;
	}
	
	
}
