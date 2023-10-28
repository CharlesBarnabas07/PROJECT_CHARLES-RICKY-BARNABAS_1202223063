import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Database {
    
    // TODO: Create List of Konser Object to Store Konser from Konser Class
    private List<Konser> konserList;

    // Constructor to initialize the list
    public Database() {
        this.konserList = new ArrayList<>();
    }

    // TODO: Create Method to insert Konser to Database
    public void insertKonser(Konser konser) {
        konserList.add(konser);
    }

    // TODO: Create Method to Show Konser from Database
    public void showKonser() {
        System.out.println("==============================");
        System.out.println("Daftar Acara Konser yang Tersedia:");
        int number = 1;
        for (Konser konser : konserList) {
            System.out.println("\n" + number+"." + konser.getBandName());
            System.out.println("Tanggal Konser: " + konser.getDate());
            System.out.println("Lokasi: " + konser.getLocation());
            System.out.println("Harga Tiket: " + konser.getTicketPrice());
            System.out.println("==============================");
            number ++;
        }
    }

    // TODO: Create Method to Buy Ticket and Show the Total Price
    public void buyTicket(){
        Scanner input = new Scanner(System.in);

        System.out.print("Pilih nomor Konser yang akan dibeli: ");
        int selectedBand = input.nextInt();

        if (selectedBand >= 1 && selectedBand <= konserList.size()) {
            Konser selectedKonser = konserList.get(selectedBand - 1);
            System.out.print("Jumlah Tiket yang akan dibeli: ");
            int ticketCount = input.nextInt();
            double totalPrice = ticketCount * selectedKonser.getTicketPrice();
            System.out.println("==============================");
            System.out.println("Selamat Anda Berhasil Membeli Tiket Konser " + selectedKonser.getBandName());
            System.out.println("Jumlah Tiket yang dibeli : " + ticketCount);
            System.out.println("Total Harga: " + totalPrice);
            System.out.println("==============================");
        }
    }
}
