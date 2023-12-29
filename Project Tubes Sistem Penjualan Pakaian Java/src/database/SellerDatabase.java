package database;

import java.io.*;
import java.util.ArrayList;

public class SellerDatabase {
    private static final String SELLER_FILE = "sellers.txt";

    public static ArrayList<model.Seller> loadSellers() {
        ArrayList<model.Seller> sellers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(SELLER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String email = parts[2].trim();
                String password = parts[3].trim();

                model.Seller seller = new model.Seller(id, name, email, password);
                sellers.add(seller);
            }
        } catch (FileNotFoundException e) {
            // File not found, return empty list
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sellers;
    }

    public static void saveSellers(ArrayList<model.Seller> sellers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(SELLER_FILE))) {
            for (model.Seller seller : sellers) {
                writer.println(seller.getIdSeller() + ", " + seller.getNamaSeller() + ", " + seller.getEmailSeller() + ", " + seller.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
