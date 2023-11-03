import java.util.Scanner;

import model.Mahasiswa;
import model.Prodi;
import repository.Database;

public class KampusApp {
    public static void main(String[] arg) {
        KampusApp kampusApp = new KampusApp();
        kampusApp.showMenu();
    }

    private Scanner scanner;
    private Database db;

    public KampusApp() {
        scanner = new Scanner(System.in);
        db = new Database();
    }

    public void showMenu() {
        System.out.println("---------------------------------");
        System.out.println("Selamat Datang di Aplikasi Kampus");
        System.out.println("Pilihan Menu:");
        System.out.println("1 -> Tambah Data Mahasiswa");
        System.out.println("2 -> Ubah Data Mahasiswa");
        System.out.println("3 -> Hapus Data Mahasiswa");
        System.out.println("4 -> Cari Data Mahasiswa");
        System.out.println("5 -> Tampilkan Semua Data Mahasiswa");
        System.out.println("6 -> Tambah Data Prodi");
        System.out.println("7 -> Hapus Data Prodi");
        System.out.println("8 -> Tampil Data Prodi");
        System.out.println("0 -> Keluar Aplikasi");
        System.out.print("Silahkan masukan menu yang dipilih: ");
        int menuYangDipilih = scanner.nextInt();
        scanner.nextLine();
        switch(menuYangDipilih) {
            case 1:
            menuTambah();
            break;
            case 2:
            menuUbah();
            break;
            case 3:
            menuHapus();
            break;
            case 4:
            menuCari();
            break;
            case 5: 
            menuTampilSemua();
            break;
            case 6:
            menuTambahProdi();
            break;
            case 7:
            menuHapusProdi();
            break;
            case 8:
            menuTampilSemuaProdi();
            break;
            default: {
                System.out.print("* Terimakasih sudah menggunakan Aplikasi Kampus *");
                System.exit(0);
            }
            break;
        }
        scanner.close();
    }

    public void menuTambah() {
        System.out.println("----- Menu Tambah Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan ID Prodi: ");
        String idProdi = scanner.nextLine();
        Prodi prodi = db.prodiTbl.getProdiById(idProdi);
        if (prodi == null) {
            System.out.println("* ID Prodi tidak ditemukan *");
        } else {
            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, prodi);
            db.mahasiswaTbl.create(mahasiswa);
            System.out.println("* Mahasiswa berhasil ditambahkan *");
        }
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuUbah() {
    System.out.println("----- Menu Ubah Data Mahasiswa -----");
    System.out.print("Masukan NIM Sebelumnya: ");
    String nimLama = scanner.nextLine();
    System.out.print("Masukan NIM: ");
    String nimBaru = scanner.nextLine();
    System.out.print("Masukan Nama: ");
    String nama = scanner.nextLine();
    System.out.print("Masukkan ID Prodi: ");
    String idProdi = scanner.nextLine();
    Prodi prodi = db.prodiTbl.getProdiById(idProdi);
    if (prodi == null) {
        System.out.println("* ID Prodi tidak ditemukan. Tambahkan Prodi terlebih dahulu *");
    } else {
        Mahasiswa mahasiswa = new Mahasiswa(nimBaru, nama, prodi);
        db.mahasiswaTbl.update(nimLama, mahasiswa);
        System.out.println("* Data Mahasiswa berhasil diubah *");
    }
    System.out.println("Tekan Enter untuk melanjutkan...");
    scanner.nextLine();
    showMenu();
    }

    public void menuCari(){
        System.out.println("----- Menu Cari Data Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String input = scanner.nextLine();
        Mahasiswa mahasiswa = db.mahasiswaTbl.getMahasiswaByNim(input);
        if (mahasiswa == null) {
            System.out.println("* Data tidak ditemukan *");
        } 
        else {
            System.out.println("* NIM: " + mahasiswa.getNim() + " *");
            System.out.println("* Nama: " + mahasiswa.getNama() + " *");
            if (mahasiswa.getProdi() != null) {
                System.out.println("* Prodi ID: " + mahasiswa.getProdi().getId() + " *");
                System.out.println("* Prodi Nama: " + mahasiswa.getProdi().getNama() + " *");
            }
        }
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuHapus() {
        System.out.println("----- Menu Hapus Data Mahasiswa -----");
        System.out.print("Masukan NIM: ");
        String nim = scanner.nextLine();
        db.mahasiswaTbl.delete(nim);
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuTampilSemua() {
        System.out.println("----- Semua Data Mahasiswa -----");
        if (db.getTables().dataMahasiswa == null || db.getTables().dataMahasiswa.isEmpty()) {
            System.out.println("Data Mahasiswa Kosong, silahkan tambah data!");
        }
        else{
            for (Mahasiswa mahasiswa : db.getTables().dataMahasiswa) {
            System.out.println("* NIM: " + mahasiswa.getNim() + " *");
            System.out.println("* Nama: " + mahasiswa.getNama() + " *");
                if (mahasiswa.getProdi() != null) {
                    System.out.println("* ID Prodi: " + mahasiswa.getProdi().getId() + " *");
                    System.out.println("* Nama Prodi: " + mahasiswa.getProdi().getNama() + " *");
                }
            }
        System.out.println("-----------------------------");
        }
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuTambahProdi() {
        System.out.println("----- Menu Tambah Prodi -----");
        System.out.print("Masukan ID Prodi: ");
        String idProdi = scanner.nextLine();
        System.out.print("Masukan Nama Prodi: ");
        String namaProdi = scanner.nextLine();

        Prodi prodi = new Prodi(idProdi, namaProdi);
        db.prodiTbl.create(prodi);

        System.out.println("* Prodi berhasil ditambahkan *");
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuHapusProdi() {
        System.out.println("----- Menu Hapus Data Prodi -----");
        System.out.print("Masukkan ID Prodi: ");
        String idProdi = scanner.nextLine();
        db.prodiTbl.delete(idProdi);
        System.out.println("* Data Prodi berhasil dihapus *");
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }

    public void menuTampilSemuaProdi() {
        System.out.println("----- Semua Data Prodi -----");
        if (db.getTables().dataProdi == null || db.getTables().dataProdi.isEmpty()) {
            System.out.println("Data Prodi Kosong, silahkan tambah data!");
        } else {
            for (Prodi prodi : db.getTables().dataProdi) {
                System.out.println("* ID Prodi: " + prodi.getId() + " *");
                System.out.println("* Nama Prodi: " + prodi.getNama() + " *");
            }
            System.out.println("-----------------------------");
        }
        System.out.println("Tekan Enter untuk melanjutkan...");
        scanner.nextLine();
        showMenu();
    }
}