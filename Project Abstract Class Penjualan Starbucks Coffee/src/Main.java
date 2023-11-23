public class Main {
    public static void main(String[] args) {
        Makanan pesanmakanan = new Makanan();
        pesanmakanan.tampilkanInfo();
        pesanmakanan.prosesPemesanan();

        Minuman pesanminuman = new Minuman();
        pesanminuman.tampilkanInfo();
        pesanminuman.prosesPemesanan();

        Customer pelanggan = new Customer();
        pelanggan.tampilkanInfo();
        pelanggan.prosesPemesanan();
    }
}
