import java.util.ArrayList;
import java.util.Scanner;
import database.SellerTable;
import function.CrudItem;
import model.Seller;


public class MainApp {
    private static ArrayList<Seller> sellers;
    private static CrudItem crudItem;
    private static Scanner scanner;
    private static SellerTable sellerTable;


    static {
        sellers = database.SellerDatabase.loadSellers();
        sellerTable = new SellerTable();
        crudItem = new CrudItem(sellerTable);
        scanner = new Scanner(System.in);
    }


    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        mainApp.firstMenu();
    }


    public void firstMenu() {
        System.out.println("\n\n---------- Tanah Abang Store ----------");
        System.out.println("| Selamat Datang di Tanah Abang Store");
        System.out.println("| Sudah punya akun?");
        System.out.println("-------------------------------------------");
        System.out.println("| 1. Seller Login ");
        System.out.println("| 2. Seller Sign Up");
        System.out.println("| 3. Exit");
        System.out.print("| Masukkan pilihan anda: ");
        int pill = scanner.nextInt();

        switch (pill) {
            case 1:
                sellers = database.SellerDatabase.loadSellers();
                if (sellers.isEmpty()) {
                    System.out.println("-------------------------------------------");
                    System.out.println("Tidak ada Seller terdaftar.");
                    System.out.println("Silakan sign up sebagai Seller terlebih dahulu!");
                    signUpSeller();
                    break;
                } else {
                    loginSeller();
                    break;
                }
            case 2:
                signUpSeller();
                break;
            case 3:
                System.out.println("Keluar dari program, Terimakasih!");
                database.SellerDatabase.saveSellers(sellers);
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    }


    public void signUpSeller() {
        System.out.println("\n-------------------------------------------");
        System.out.println("| Seller Sign Up");
        System.out.println("-------------------------------------------");
        System.out.print("| Masukkan ID : ");
        int idSeller = scanner.nextInt();
        scanner.nextLine();
        System.out.print("| Masukkan Nama : ");
        String namaSeller = scanner.nextLine();
        System.out.print("| Masukkan Email : ");
        String emailSeller = scanner.next();
        System.out.print("| Masukkan Password: ");
        String password = scanner.next();

        Seller seller = new Seller(idSeller, namaSeller, emailSeller, password);
        seller.RegisterSellerMember();
        sellers.add(seller);
        database.SellerDatabase.saveSellers(sellers);
        System.out.println("Seller berhasil ditambahkan!");
        firstMenu();
    }

    
    public void loginSeller() {
        while (true) {
            sellers = database.SellerDatabase.loadSellers();
            System.out.println("\n-------------------------------------------");
            System.out.println("| Seller Login");
            System.out.println("-------------------------------------------");
            System.out.print("| Masukkan ID: ");
            int id = scanner.nextInt();
            System.out.print("| Masukkan Password: ");
            String password = scanner.next();

            for (Seller seller : sellers) {
                if (seller.getIdSeller() == id && seller.getPassword().equals(password)) {
                    System.out.println("-------------------------------------------");
                    System.out.println("Seller Login Berhasil!");
                    sellerTable = new SellerTable();
                    mainMenu();
                    return;
                }
            }
            System.out.println("-------------------------------------------");
            System.out.println("ID atau Password tidak valid!");
        }
    }
    

    public void mainMenu() {
        System.out.println("\n\n---------- Tanah Abang Store --------------");
        System.out.println("| Selamat Datang di Tanah Abang Store");
        System.out.println("-------------------------------------------");
        System.out.println("| Menu :");
        System.out.println("| 1. Tambah Pakaian di Stok");
        System.out.println("| 2. Hapus Pakaian di Stok");
        System.out.println("| 3. Tampil Semua Pakaian di Stok");
        System.out.println("| 4. Merubah Informasi Pakaian");
        System.out.println("| 5. Membuat Struk Pembelian Pakaian");
        System.out.println("| 6. Keluar");
        System.out.print("| Masukkan pilihan anda: ");
        int pilih = scanner.nextInt();
        scanner.nextLine();

        switch (pilih) {
            case 1:
                crudItem.tambahItem();
                mainMenu();
                break;
            case 2:
                crudItem.hapusItem();
                mainMenu();
                break;
            case 3:
                crudItem.tampilSemuaItem();
                mainMenu();
                break;
            case 4:
                crudItem.ubahDataItem(crudItem.getAllItems());
                mainMenu();
                break;
            case 5:
                crudItem.transaksiDenganCustomer();
                mainMenu();
                break;
            case 6:
                database.SellerDatabase.saveSellers(sellers);
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    }
}
