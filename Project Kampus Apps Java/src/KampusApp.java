import java.util.ArrayList;
import java.util.Scanner;
public class KampusApp {

    public static void main(String[] args) {
        KampusApp kampusApp = new KampusApp();
        kampusApp.showMenu ();
    }

    private Scanner scanner;
    private Database database;
    private FileHelper fileHelper;

    public KampusApp() {
        scanner = new Scanner(System.in);
        database = new Database ();
        fileHelper = new FileHelper();
    }

    public void showMenu() {
        System.out.println("\n=================================");
        System.out.println("Selamat Datang di Aplikasi Kampus");
        System.out.println("Pilihan Menu:");
        System.out.println("1 -> Tambah Data Mahasiswa");
        System.out.println("2 -> Ubah Data Mahasiswa");
        System.out.println("3 -> Hapus Data Mahasiswa");
        System.out.println("4 -> Cari Data Mahasiswa");
        System.out.println("5 -> Tampil Data Mahasiswa");
        System.out.println("6 -> Hapus Data Mahasiswa");
        System.out.println("7 -> Ganti Nama File Data Mahasiswa");
        System.out.println("0 -> Keluar Aplikasi");
        System.out.print ("Tolong masukan menu yang dipilih: ");
        int menuYangDipilih = scanner.nextInt ();
        scanner. nextLine();
        switch(menuYangDipilih) {
            case 1:
            menuTambah();
            break;
            case 2:
            menuUbah();
            break;
            case 3: 
            menuHapus ();
            break;
            case 4:
            menuCari();
            break;
            case 5:
            menuTampilkanSemua();
            break;
            case 6:
            menuHapusData();
            break;
            case 7:
            menuGantiNamaFile();
            break;
            case 0: 
            {
            System.out.print("* Terimakasih sudah menggunakan Aplikasi Kampus *");
            System.out.println("================================");
            System.exit(0);
            }
            default:
            System.out.print("Pilihan tidak valid, silahkan masukkan menu yang tersedia.");
            showMenu();
        }
        scanner. close();
    }

    public void menuTambah() {
        System.out.println("\n----- Menu Tambah Mahasiswa -----");
        System.out.print ("Masukan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jenis Kelamin: ");
        String jeniskelamin = scanner.nextLine();
        System.out.print("Masukkan Usia: ");
        String usia = scanner.nextLine();
        System.out.print("Masukkan Email: ");
        String email = scanner.nextLine();
        Mahasiswa mahasiswa = new Mahasiswa(nim, nama, jeniskelamin, usia, email);
        database.create(mahasiswa);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine ();
        showMenu();
    }

    public void menuHapusData(){
        fileHelper.clearFileContent();
        System.out.println("\n--- Data Mahasiswa Sudah Dihapus ---");
        showMenu();
    }

    public void menuUbah () {
        System.out.println("\n----- Menu Ubah Data Mahasiswa -----");
        System.out.print ("Masukan NIM Sebelumnya: ");
        String nimLama = scanner.nextLine();
        System.out.print("Masukan NIM: ");
        String nimBaru = scanner.nextLine();
        System.out.print("Masukan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukan Jenis Kelamin: ");
        String jeniskelamin = scanner.nextLine();
        System.out.print("Masukan Usia: ");
        String usia = scanner.nextLine();
        System.out.print("Masukkan Email: ");
        String email = scanner.nextLine();
        Mahasiswa mahasiswa = new Mahasiswa(nimBaru, nama, jeniskelamin, usia, email);
        database.update (mahasiswa, nimLama);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuTampilkanSemua() { 
    System.out.println("\n-- Menampilkan Semua Data Mahasiswa --");
    ArrayList<Mahasiswa> semuaMahasiswa = database.read();
    if (semuaMahasiswa.isEmpty()) {
        System.out.println("Tidak ada data mahasiswa yang tersimpan.");
    } else {
        System.out.println("Daftar Mahasiswa:");
        for (Mahasiswa mahasiswa : semuaMahasiswa) {
            System.out.println("NIM: " + mahasiswa.getNim());
            System.out.println("Nama: " + mahasiswa.getNama());
            System.out.println("Jenis Kelamin: " + mahasiswa.getJenisKelamin());
            System.out.println("Usia: " + mahasiswa.getUsia());
            System.out.println("Email: " + mahasiswa.getEmail());
            }
        }
    showMenu();
    }

    public void menuHapus () {
        System.out.println("\n----- Menu Cari Data Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        database.delete(nim);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine (); 
        showMenu();
    }

    public void menuCari(){
        System.out.println("\n----- Menu Cari Data Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        Mahasiswa mahasiswa = database.read(nim);
        if(mahasiswa == null) {
            System.out.println("* NIM tidak ditemukan *");
        } 
        else {
            System.out.println("* NIM: " + mahasiswa.getNim() + " *");
            System.out.println("* Nama: " + mahasiswa.getNama () + " *");
            System.out.println("* Jenis Kelamin: " + mahasiswa.getJenisKelamin() + " *");
            System.out.println("* Usia: " + mahasiswa.getUsia() + " *");
            System.out.println("* Email: " + mahasiswa.getEmail() + " *");
            System.out.println("Tekan Enter untuk melanjutkan...");
            scanner. nextLine ();
            showMenu ();
        }
    }

    public void menuGantiNamaFile() {
        System.out.println("\nNama file saat ini: " + fileHelper.getNamaFileDataMahasiswa());
        System.out.print("Masukkan nama baru untuk file: ");
        String namaBaru = scanner.nextLine();

        fileHelper.gantiNamaFile(namaBaru);

        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

} 