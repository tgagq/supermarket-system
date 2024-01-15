package SistemSupermarketi;
import java.util.*;
import java.util.Scanner;


public class ShportaBlerjeve {
	 private Map<Produkt, Integer> produktetNeShporte;
	    private Klient klient;

	    public ShportaBlerjeve(Klient klient) {
	        this.klient = klient;
	        this.produktetNeShporte = new HashMap<>();
	    }

	    public void shtoProdukt(Produkt produkt, int sasia) {
	        if (produktetNeShporte.containsKey(produkt)) {
	            produktetNeShporte.put(produkt, produktetNeShporte.get(produkt) + sasia);
	        } else {
	            produktetNeShporte.put(produkt, sasia);
	        }
	    }

	    public void hiqProdukt(Produkt produkt, int sasia) {
	        if (produktetNeShporte.containsKey(produkt)) {
	            int sasiaNeShporte = produktetNeShporte.get(produkt);
	            if (sasiaNeShporte <= sasia) {
	                produktetNeShporte.remove(produkt);
	            } else {
	                produktetNeShporte.put(produkt, sasiaNeShporte - sasia);
	            }
	        } else {
	            System.out.println("Produkti nuk ekziston në shportë.");
	        }
	    }

	    public Map<Produkt, Integer> getProduktetNeShporte() {
	        return produktetNeShporte;
	    }

	    public Klient getKlient() {
	        return klient;
	    }
	    
	    public void shtoProdukteNeShporte(Scanner scanner,List<Produkt> produktet) {
            for (Produkt produkt : produktet) {
                System.out.print("Shto sasi për " + produkt.getEmri() + " (shtypni 0 për të anashkaluar): ");
                int sasiaNeShporte = scanner.nextInt();
                if (sasiaNeShporte > 0) {
                    shtoProdukt(produkt, sasiaNeShporte);
                }
            }
        }
	   
}