package cl.jotaeme.microservicios.app.entidad;
// POJO de una Crypto Currency
public class CryptoCurrency {

	private String name;
	private String acronym;
	private String price_USD;
	private String changeLast24Hours;
	private String marketCap_USD;
	private String volumenLast24Hours_USD;
	private String updateDate;
	
	public CryptoCurrency() {
		
	}

	public CryptoCurrency(String name, String acronym, String price_USD, String changeLast24Hours, String marketCap_USD,
			String volumenLast24Hours_USD, String updateDate) {
		super();
		this.name = name;
		this.acronym = acronym;
		this.price_USD = price_USD;
		this.changeLast24Hours = changeLast24Hours;
		this.marketCap_USD = marketCap_USD;
		this.volumenLast24Hours_USD = volumenLast24Hours_USD;
		this.updateDate = updateDate;
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

	public String getPrice_USD() {
		return price_USD;
	}

	public void setPrice_USD(String price_USD) {
		this.price_USD = price_USD;
	}

	public String getChangeLast24Hours() {
		return changeLast24Hours;
	}

	public void setChangeLast24Hours(String changeLast24Hours) {
		this.changeLast24Hours = changeLast24Hours;
	}

	public String getMarketCap_USD() {
		return marketCap_USD;
	}

	public void setMarketCap_USD(String marketCap_USD) {
		this.marketCap_USD = marketCap_USD;
	}

	public String getVolumenLast24Hours_USD() {
		return volumenLast24Hours_USD;
	}

	public void setVolumenLast24Hours_USD(String volumenLast24Hours_USD) {
		this.volumenLast24Hours_USD = volumenLast24Hours_USD;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
