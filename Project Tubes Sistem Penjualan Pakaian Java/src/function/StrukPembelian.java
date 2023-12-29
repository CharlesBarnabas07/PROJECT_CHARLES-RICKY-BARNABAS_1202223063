package function;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.Chinos;
import model.Item;
import model.Jaket;
import model.Kaos;

public class StrukPembelian {
    public static void buatStruk(String namaCustomer, List<? extends Item> items, int totalHarga) {
        try (FileWriter writer = new FileWriter("struk_pembelian.txt")) {
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDateTime = dateTime.format(formatter);

            writer.write("---------- Struk Pembelian ----------\n");
            writer.write("Waktu Pembelian: " + formattedDateTime + "\n");
            writer.write("Nama Customer: " + namaCustomer + "\n");
            writer.write("------------------------------------\n");

            for (Item item : items) {
                writer.write("ID: " + item.getIdItem() + "\n");
                writer.write("Nama: " + item.getNama() + "\n");
                writer.write("Jenis: " + item.getJenisPakaian() + "\n");

                if (item instanceof Chinos) {
                    Chinos chinosItem = (Chinos) item;
                    writer.write("Warna: " + chinosItem.getWarnaChinos() + "\n");
                }

                if (item instanceof Jaket) {
                    Jaket jaketItem = (Jaket) item;
                    writer.write("Warna: " + jaketItem.getWarnaJaket() + "\n");
                }

                if (item instanceof Kaos) {
                    Kaos kaosItem = (Kaos) item;
                    writer.write("Warna: " + kaosItem.getWarnaKaos() + "\n");
                }

                writer.write("Jumlah Beli: " + item.getJumlahBeli() + "\n");
                writer.write("Harga Satuan: Rp " + item.getHarga() + "\n");
                writer.write("------------------------------------\n");
            }

            writer.write("Total Harga: Rp " + totalHarga + "\n");

            System.out.println("Struk pembelian telah dibuat: struk_pembelian.txt");
        } catch (IOException e) {
            System.out.println("Error while creating struk: " + e.getMessage());
        }
    }
}
