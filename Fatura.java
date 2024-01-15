package SistemSupermarketi;
import java.util.*;

public class Fatura {
	private ShportaBlerjeve shporta;
    private double totali;

    public Fatura(ShportaBlerjeve shporta) {
        this.shporta = shporta;
        llogaritTotalin();
    }

    private void llogaritTotalin() {
        totali = 0;
        for (Map.Entry<Produkt, Integer> entry : shporta.getProduktetNeShporte().entrySet()) {
            totali += entry.getKey().getCmimi() * entry.getValue();
        }
    }

    public double getTotali() {
        return totali;
    }

    public void printFatura() {
        System.out.println("=== Fatura ===");
        for (Map.Entry<Produkt, Integer> entry : shporta.getProduktetNeShporte().entrySet()) {
            System.out.println(entry.getKey().getEmri() + ": " + entry.getKey().getCmimi() + " x " + entry.getValue());
        }
        System.out.println("Totali: " + totali);
        System.out.println("Klienti: " + shporta.getKlient().getEmri());
    }

    public void paguaj(double shuma) {
        if (shuma >= totali) {
            System.out.println("Pagesa e pranuar. Faleminderit!");
        } else {
            System.out.println("Pagesa e pamjaftueshme. Ju lutem provoni përsëri.");
        }
    }
    
   

}