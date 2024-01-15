package SistemSupermarketi;

public class Klient {
	private String emri;
    private String adresa;
    private int pike;

    public Klient(String emri, String adresa, int pike) {
        this.emri = emri;
        this.adresa = adresa;
        this.pike = pike;
        
    }

    public String getEmri() {
        return emri;
    }

    public String getAdresa() {
        return adresa;
    }
    
    public int getPike() {
    	return pike;
    }

	public void setEmri(String emri) {
		this.emri = emri;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public void setPike(int pike) {
		this.pike = pike;
	}
	
	@Override
    public String toString() {
        return emri + " " + adresa + " " + pike;
    }
    
    
    
}