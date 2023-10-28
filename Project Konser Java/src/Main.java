import java.util.Scanner;

import javax.xml.crypto.Data;

public class Main {
    public static void main(String[] args){
        // TODO: Create Database Object
        Database database = new Database();

        // TODO: Create Konser Object and Set the Attributes
        Konser konser1 = new Konser();
        konser1.setBandName("Coldplay");
        konser1.setDate("12-12-2023");
        konser1.setLocation("Jakarta");
        konser1.setTicketPrice(570000.0);

        Konser konser2 = new Konser();
        konser2.setBandName("Westlife");
        konser2.setDate("25-12-2023");
        konser2.setLocation("Bandung");
        konser2.setTicketPrice(370000.0);

        // TODO: Insert Konser Object to Database
        database.insertKonser(konser1);
        database.insertKonser(konser2);

        // TODO: Display Greeting Message and Prompt User to Register
        System.out.println("Selamat Datang di Konser EAD");
        System.out.println("Silahkan Register Terlebih Dahulu");
        System.out.println("==============================");
        
        // TODO: Create a User Object and Set the Attributes
        User userobject = new User();
        Scanner input = new Scanner(System.in);
        System.out.print("Nama: ");
        userobject.setName(input.nextLine());
        System.out.print("No Handphone: ");
        userobject.setPhoneNumber(input.nextLine());
        System.out.println("==============================");
        userobject.RegisterDisplayUser();
        System.out.println("==============================");
    
        // TODO: Display Main Menu and Prompt User to Choose Menu

        System.out.println("1. Lihat Konser");
        System.out.println("2. Beli Tiket");
        System.out.println("3. Keluar");
        System.out.print("Silahkan Pilih Menu: ");
        Scanner menuInput = new Scanner(System.in);
        int choice = menuInput.nextInt();

        switch (choice) {
            case 1:
                database.showKonser();
                break;
            case 2:
                database.buyTicket();
                break;
            case 3:
                System.out.println("Terimakasih");
                break;
        }
        
    } 
}
