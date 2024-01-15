package SistemSupermarketi;
import java.util.*;

public class SupermarketManager {
	private Map<String, Produkt> produktet;

    public SupermarketManager() {
        this.produktet = new HashMap<>();
    }
    
    // Metoda për të marrë një listë të produkteve
    public List<Produkt> getProduktet() {
        return new ArrayList<>(produktet.values());
    }
    /////////////////////////////////////////////////////
    public void shtoProdukt(Produkt produkt) {
        produktet.put(produkt.getEmri(), produkt);
    }

    public void hiqProdukt(String emri) {
        produktet.remove(emri);
    }

    public Produkt gjejProdukt(String emri) {
        return produktet.get(emri);
    }

    
    
    public void printStoku() {
        System.out.println("=== Stoku ===");
        for (Map.Entry<String, Produkt> entry : produktet.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getSasiaNeStok());
        }
    }
}