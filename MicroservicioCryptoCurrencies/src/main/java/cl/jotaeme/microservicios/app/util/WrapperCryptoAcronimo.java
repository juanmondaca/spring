package cl.jotaeme.microservicios.app.util;

import java.util.ArrayList;
import java.util.List;

import cl.jotaeme.microservicios.app.entidad.CryptoAcronimo;

public class WrapperCryptoAcronimo {
	
	private List<CryptoAcronimo> listaCA = new ArrayList<>();

	public WrapperCryptoAcronimo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<CryptoAcronimo> getListaCA() {
		return listaCA;
	}

	public void setListaCA(List<CryptoAcronimo> listaCA) {
		this.listaCA = listaCA;
	}
}
