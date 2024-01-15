package SistemSupermarketi;



public class Produkt {
	 private String emri;
	    private double cmimi;
	    private int sasiaNeStok;

	    public Produkt(String emri, double cmimi, int sasiaNeStok) {
	        this.emri = emri;
	        this.cmimi = cmimi;
	        this.sasiaNeStok = sasiaNeStok;
	    }

	    public String getEmri() {
	        return emri;
	    }

	    public double getCmimi() {
	        return cmimi;
	    }

	    public int getSasiaNeStok() {
	        return sasiaNeStok;
	    }
	    
	    
	    public void setEmri(String emri) {
			this.emri = emri;
		}

		public void setCmimi(double cmimi) {
			this.cmimi = cmimi;
		}

		public void setSasiaNeStok(int sasiaNeStok) {
			this.sasiaNeStok = sasiaNeStok;
		}

		public void zbresSasineNeStok(int sasia) {
	        if (sasiaNeStok >= sasia) {
	            sasiaNeStok -= sasia;
	        } else {
	            System.out.println("Nuk ka mjaftueshëm produkte në stok.");
	        }
	    }
	}