package SistemSupermarketi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KlientManager {
    private List<Klient> clients;
    private String filePath = "clients.txt";
    
    public KlientManager() {
        this.clients = new ArrayList<>();
        loadClientsFromFile();
    }
    
    public void addClient(Klient client) {
        clients.add(client);
        saveClientsToFile();
    }
    
    public List<Klient> getClients() {
        return clients;
    }
    
    public Klient gjejKlientin(String name) {
    	for(Klient klient: clients) {
    		if(klient.getEmri().equals(name)) {
    			return klient;
    		}
    	}
    	return null;
    }
    
    public void loadClientsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    String name = parts[0];
                    String address = parts[1];
                    int points = Integer.parseInt(parts[2]);
                    clients.add(new Klient(name, address, points));
                }
            }
        } catch (IOException e) {
        	File file = new File(filePath);
            e.printStackTrace();
            
        }
    }
    
    public void saveClientsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Klient client : clients) {
                writer.write(client.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
