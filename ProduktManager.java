package SistemSupermarketi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProduktManager {
    private List<Produkt> products;
    private String filePath = "products.txt";;

    public ProduktManager() {
        this.products = new ArrayList<>();
        loadProductsFromFile();
    }

    public void addProduct(Produkt product) {
        products.add(product);
        saveProductsToFile();
    }

    public List<Produkt> getProducts() {
        return products;
    }

    private void loadProductsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    String name = parts[0];
                    int stock = Integer.parseInt(parts[1]);
                    double price = Double.parseDouble(parts[2]);
                    products.add(new Produkt(name, price, stock));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveProductsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Produkt product : products) {
                writer.write(product.toString());
                writer.newLine();
            }
        } catch (IOException e) {
        	File file = new File(filePath);        	
            e.printStackTrace();
        }
    }
    
    public Produkt gjejProduktin(String name) {
    	for(Produkt produkt: products) {
    		if(produkt.getEmri().equals(name)) {
    			return produkt;
    		}
    	}
    	return null;
    }
}

