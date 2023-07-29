package data;

public class FinanceProduct {
	
	private int id;
	private String bezeichnung;
	private Long standing;
	
	public FinanceProduct(int id, String bezeichnung, long standing) {
		this.id = id;
		this.bezeichnung = bezeichnung;
		this.standing = standing;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public Long getStanding() {
		return standing;
	}

	public void setStanding(Long standing) {
		this.standing = standing;
	}

}
