package SistemSupermarketi;
import java.util.List;
import java.io.File; 
import java.util.Scanner;


public class SupermarketSystem {
	
	public static void menu() {
		System.out.println("1.Shto produkt:");
		System.out.println("2.Shto klient:");
		System.out.println("3.Kryej blerje:");
		System.out.println("4.Dil");
	}
	
	public static Produkt shtoProdukt() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Emri i produktit: ");
        String emri = scanner.next();
        System.out.print("Cmimi i produktit: ");
        double cmimi = scanner.nextDouble();
        System.out.print("Sasia e produktit: ");
        int sasia = scanner.nextInt();
        Produkt produkt = new Produkt(emri, cmimi, sasia);
        scanner.close();
        return produkt;
	}
	
	public static Klient shtoKlient() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Emri i klientit: ");
        String emriKlientit = scanner.next();

        System.out.print("Adresa e klientit: ");
        String adresa = scanner.next();

        Klient klient = new Klient(emriKlientit, adresa, 0);
        scanner.close();
        return klient;
	}
	
	public static ProduktManager shtoNeShporte(ProduktManager pmanager, KlientManager manager) {
		Scanner scanner = new Scanner(System.in);
		SupermarketManager supermarketManager = new SupermarketManager();
		boolean yes = true;
		while(yes) {
			System.out.println("Produkti: ");
			System.out.println("(Shkruaj stop per te ndaluar)");
			String produkti = scanner.next();
			if(produkti.equals("stop")) {
				return pmanager;
			}
			Produkt dudu = pmanager.gjejProduktin(produkti);
			System.out.println("Sasia: ");
			int sasia = scanner.nextInt();
			if((dudu.getSasiaNeStok() - sasia) >= 0) {
				dudu.setSasiaNeStok(dudu.getSasiaNeStok() - sasia);
				if(dudu != null) {
					supermarketManager.shtoProdukt(dudu);
				}
			}
			
		}
		Klient klient;
		while(true) {
			System.out.println("Klienti: ");
			System.out.println("(Shkruaj stop per te ndaluar)");
			String klienti = scanner.next();
			if(klienti.equals("stop")) {
				return pmanager;
			}
			klient = manager.gjejKlientin(klienti);
			if(klient != null) {
				System.out.println("Klienti nuk u gjet!");
			}
		}
		
        ShportaBlerjeve shporta = new ShportaBlerjeve(klient);
        List<Produkt> produktet = supermarketManager.getProduktet();
        shporta.shtoProdukteNeShporte(scanner, produktet);
      
        // Printoni faturën dhe stokun
        Fatura fatura = new Fatura(shporta);
        fatura.printFatura();

        supermarketManager.printStoku();

        // Mbylleni scannerin
        scanner.close();
        return pmanager;
	}
	
	 public static void main(String[] args) {
	     boolean go = true;
	     KlientManager manager = new KlientManager();
	     ProduktManager pmanager = new ProduktManager();
	     Scanner scanner = new Scanner(System.in);
		 while(go) {
			 menu();
			 int input = scanner.nextInt();
			 switch(input) {
			 case 1:
				 pmanager.addProduct(shtoProdukt());
				 break;
			 case 2:
				 manager.addClient(shtoKlient());;
				 break;
			 case 3:
				 pmanager = shtoNeShporte(pmanager, manager);
				 manager.saveClientsToFile();
				 break;
			 case 4:
				 manager.saveClientsToFile();
				 break;
			 }
		 }
	 }
}