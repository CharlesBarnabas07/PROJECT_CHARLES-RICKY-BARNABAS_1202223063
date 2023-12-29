package function;

import java.util.ArrayList;
import java.util.Scanner;
import database.SellerTable;
import model.Chinos;
import model.Item;
import model.Jaket;
import model.Kaos;

public class CrudItem {
    private Scanner input;
    private SellerTable sellerTable;

    public CrudItem(SellerTable sellerTable) {
        this.input = new Scanner(System.in);
        this.sellerTable = sellerTable;
    }

    public ArrayList<? extends Item> getAllItems() {
        ArrayList<Item> allItems = new ArrayList<>();
        allItems.addAll(sellerTable.getListChinos());
        allItems.addAll(sellerTable.getListJaket());
        allItems.addAll(sellerTable.getListKaos());
        return allItems;
    }


    public void tambahItem() {
        System.out.println("-------------------------------------------");
        System.out.println("| Tambah Item : ");
        System.out.println("| Item apa yang ingin anda tambahkan? ");
        System.out.println("| 1. Chinos");
        System.out.println("| 2. Jaket");
        System.out.println("| 3. Kaos");
        System.out.println("| 4. Main Menu");
        System.out.println("-------------------------------------------");
        System.out.print("| Masukkan pilihan anda: ");
        int tambahpill = input.nextInt();
    
        switch (tambahpill) {
            case 1:
                tambahProduk("Chinos");
                break;
    
            case 2:
                tambahProduk("Jaket");
                break;
    
            case 3:
                tambahProduk("Kaos");
                break;
        }
    }
    
    private void tambahProduk(String jenisProduk) {
        System.out.print("| Masukkan Id " + jenisProduk + ": ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("| Masukkan Jenis " + jenisProduk + ": ");
        String jenis = input.nextLine();
        System.out.print("| Masukkan Nama " + jenisProduk + ": ");
        String nama = input.nextLine();
        System.out.print("| Masukkan Warna " + jenisProduk + ": ");
        String warna = input.nextLine();
        System.out.print("| Masukkan Jumlah " + jenisProduk + ": ");
        int jumlah = input.nextInt();
        System.out.print("| Masukkan Harga " + jenisProduk + ": ");
        double harga = input.nextDouble();
    
        switch (jenisProduk) {
            case "Chinos":
                Chinos chinos = new Chinos(id, jenis, nama, warna, jumlah, harga);
                sellerTable.getListChinos().add(chinos);
                System.out.println("Chinos berhasil ditambahkan");
                break;
    
            case "Jaket":
                Jaket jaket = new Jaket(id, jenis, nama, warna, jumlah, harga);
                sellerTable.getListJaket().add(jaket);
                System.out.println("Jaket berhasil ditambahkan");
                break;
    
            case "Kaos":
                Kaos kaos = new Kaos(id, jenis, nama, warna, jumlah, harga);
                sellerTable.getListKaos().add(kaos);
                System.out.println("Kaos berhasil ditambahkan");
                break;
        }
    }
    


    public void hapusItem() {
        System.out.println("-------------------------------------------");
        System.out.println("| Hapus Item : ");
        System.out.println("| Pilih jenis item yang akan dihapus: ");
        System.out.println("| 1. Chinos");
        System.out.println("| 2. Jaket");
        System.out.println("| 3. Kaos");
        System.out.println("| 4. Main Menu");
        System.out.println("-------------------------------------------");
        System.out.print("| Masukkan pilihan anda: ");
        int hapuspill = input.nextInt();

        switch (hapuspill) {
            case 1:
                hapusItemById(sellerTable.getListChinos());
                break;
            case 2:
                hapusItemById(sellerTable.getListJaket());
                break;
            case 3:
                hapusItemById(sellerTable.getListKaos());
                break;
            case 4:
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    }


    public void hapusItemById(ArrayList<? extends Item> items) {
        System.out.print("| Masukkan ID item yang akan dihapus: ");
        int idItem = input.nextInt();
        System.out.print("| Masukkan jumlah item yang akan dihapus (0 untuk menghapus semua): ");
        int jumlah = input.nextInt();
    
        for (Item item : items) {
            if (item.getIdItem() == idItem) {
                int itemJumlah = 0;
    
                if (item instanceof Chinos) {
                    itemJumlah = ((Chinos) item).getJumlahChinos();
                } 
                else if (item instanceof Jaket) {
                    itemJumlah = ((Jaket) item).getJumlahJaket();
                } 
                else if (item instanceof Kaos) {
                    itemJumlah = ((Kaos) item).getJumlahKaos();
                }

                if (jumlah == 0 || itemJumlah <= jumlah) {
                    items.remove(item);
                    System.out.println("Item dengan ID " + idItem + " berhasil dihapus.");
                } else {
                    if (item instanceof Chinos) {
                        ((Chinos) item).setJumlahChinos(itemJumlah - jumlah);
                    } 
                    else if (item instanceof Jaket) {
                        ((Jaket) item).setJumlahJaket(itemJumlah - jumlah);
                    } 
                    else if (item instanceof Kaos) {
                        ((Kaos) item).setJumlahKaos(itemJumlah - jumlah);
                    }
                    System.out.println("Jumlah item dengan ID " + idItem + " berhasil dikurangi menjadi " + (itemJumlah -jumlah) + ".");
                }
                return;
            }
        }
        System.out.println("Item dengan ID " + idItem + " tidak ditemukan.");
    }
    

    public void tampilSemuaItem() {
        System.out.println("\n------------ Daftar Semua Item ------------");
        System.out.println("Chinos: ");
        System.out.println();
        for (Chinos chinos : sellerTable.getListChinos()) {
            System.out.println(chinos.information());
        }
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("Jaket: ");
        System.out.println();
        for (Jaket jaket : sellerTable.getListJaket()) {
            System.out.println(jaket.information());
        }
        System.out.println("-------------------------------------------");
        System.out.println();

        System.out.println("Kaos: ");
        System.out.println();
        for (Kaos kaos : sellerTable.getListKaos()) {
            System.out.println(kaos.information());
        }
        System.out.println("-------------------------------------------");
    }
    

    public void ubahItem() {
        System.out.println("-------------------------------------------");
        System.out.println("| Ubah Item : ");
        System.out.println("| Pilih jenis item yang akan diubah: ");
        System.out.println("| 1. Chinos");
        System.out.println("| 2. Jaket");
        System.out.println("| 3. Kaos");
        System.out.println("| 4. Kembali ke Menu Utama");
        System.out.println("-------------------------------------------");
        System.out.print("| Masukkan pilihan anda: ");
        int ubahpill = input.nextInt();
    
        switch (ubahpill) {
            case 1:
                ubahDataItem(sellerTable.getListChinos());
                break;
            case 2:
                ubahDataItem(sellerTable.getListJaket());
                break;
            case 3:
                ubahDataItem(sellerTable.getListKaos());
                break;
            case 4:
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    }
    

    public void ubahDataItem(ArrayList<? extends Item> items) {
        System.out.print("| Masukkan ID item yang akan diubah: ");
        int idItem = input.nextInt();
    
        for (Item item : items) {
            if (item.getIdItem() == idItem) {
                System.out.println("| Data Saat Ini : ");
                System.out.println(item.information());
                System.out.println();
                input.nextLine(); 
                System.out.print("| Masukkan Nama Baru : ");
                String namaBaru = input.nextLine();
                System.out.print("| Masukkan Warna Baru : ");
                String warnaBaru = input.nextLine();
                System.out.print("| Masukkan Jumlah Baru : ");
                int jumlahBaru = input.nextInt();
                System.out.print("| Masukkan Harga Baru : ");
                double hargaBaru = input.nextDouble();

                item.setAttributes(namaBaru, warnaBaru, jumlahBaru, hargaBaru);

                System.out.println("Data item dengan ID " + idItem + " berhasil diubah.");
                return;
            }
        }
        System.out.println("Item dengan ID " + idItem + " tidak ditemukan.");
    }
    

    public int getStok(Item item) {
        if (item instanceof Chinos) {
            return ((Chinos) item).getJumlahChinos();
        } else if (item instanceof Jaket) {
            return ((Jaket) item).getJumlahJaket();
        } else if (item instanceof Kaos) {
            return ((Kaos) item).getJumlahKaos();
        } else {
            return 0;
        }
    }


    public String getNama(Item item) {
        return item.getNama();
    }
    public double getHarga(Item item) {
        return item.getHarga();
    }


    public void updateStok(ArrayList<Item> itemsPurchased) {
        for (Item purchasedItem : itemsPurchased) {
            if (purchasedItem instanceof Chinos) {
                ((Chinos) purchasedItem).setJumlahChinos(((Chinos) purchasedItem).getJumlahChinos() - purchasedItem.getJumlahBeli());
            } 
            else if (purchasedItem instanceof Jaket) {
                ((Jaket) purchasedItem).setJumlahJaket(((Jaket) purchasedItem).getJumlahJaket() - purchasedItem.getJumlahBeli());
            } 
            else if (purchasedItem instanceof Kaos) {
                ((Kaos) purchasedItem).setJumlahKaos(((Kaos) purchasedItem).getJumlahKaos() - purchasedItem.getJumlahBeli());
            }
        }
    }


    public void transaksiDenganCustomer() {
        System.out.println("\n-------------------------------------------");
        System.out.println("| Transaksi dengan Customer");
        System.out.println("-------------------------------------------");
        System.out.print("| Masukkan Nama Customer: ");
        String namaCustomer = input.next();

        tampilSemuaItem();

        ArrayList<Item> itemsPurchased = new ArrayList<>();
        int totalHarga = 0;
        while (true) {
            System.out.print("| Masukkan ID item yang akan dibeli (0 untuk selesai): ");
            int idItem = input.nextInt();
            if (idItem == 0) {
                break;
            }

            Item selectedItem = null;
            for (Item item : getAllItems()) {
                if (item.getIdItem() == idItem) {
                    selectedItem = item;
                    break;
                }
            }

            if (selectedItem != null) {
                System.out.print("| Masukkan jumlah " + getNama(selectedItem) + " yang akan dibeli: ");
                int jumlahBeli = input.nextInt();
            
                if (jumlahBeli > 0 && jumlahBeli <= getStok(selectedItem)) {
                    itemsPurchased.add(selectedItem);
                    totalHarga += getHarga(selectedItem) * jumlahBeli;
                    System.out.println(getNama(selectedItem) + " sebanyak " + jumlahBeli + " berhasil ditambahkan ke keranjang.");
                    ((Item) selectedItem).setJumlahBeli(jumlahBeli);
                } else {
                    System.out.println("Jumlah yang dimasukkan tidak valid atau melebihi stok.");
                }
            } else {
                System.out.println("Item dengan ID " + idItem + " tidak ditemukan.");
            }
            
        }

        StrukPembelian.buatStruk(namaCustomer, itemsPurchased, totalHarga);
        updateStok(itemsPurchased);

        System.out.println("Transaksi berhasil!");
    }

    
}
