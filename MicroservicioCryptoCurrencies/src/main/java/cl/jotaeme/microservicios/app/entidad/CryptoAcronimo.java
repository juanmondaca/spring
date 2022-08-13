package cl.jotaeme.microservicios.app.entidad;

public class CryptoAcronimo {
	
	private String name;
	private String acronym;
	
	public CryptoAcronimo() {
		
	}
	
	public CryptoAcronimo(String name, String acronym) {
		super();
		this.name = name;
		this.acronym = acronym;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	

}
