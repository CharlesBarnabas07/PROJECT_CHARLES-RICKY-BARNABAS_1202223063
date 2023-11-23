public class Makanan extends BaseInfo {
    public String namaMakanan;
    public String hargaMakanan;
    public String infoMakanan;

    @Override
    public void tampilkanInfo() {
        System.out.println("Tampilan Info Pemesanan Makanan");
    }

    @Override
    void prosesPemesanan() {
        System.out.println("Proses Pemesanan Makanan");
    }
}
