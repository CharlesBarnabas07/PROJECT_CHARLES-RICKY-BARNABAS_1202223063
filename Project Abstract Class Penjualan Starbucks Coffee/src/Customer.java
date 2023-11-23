public class Customer extends BaseInfo{
    public String nomorCustomer;
    public String namaCustomer;
    public String emailCustomer;
    public String nohpCustomer;

    @Override
    public void tampilkanInfo() {
        System.out.println("Tampilan Info Pemesanan Makanan dan Minuman Customer");
    }

    @Override
    void prosesPemesanan() {
        System.out.println("Proses Pemesanan Makanan dan Minuman Customer");
    }
}
