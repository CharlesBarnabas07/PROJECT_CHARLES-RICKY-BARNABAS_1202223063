public class Minuman extends BaseInfo{
    public String namaMinuman;
    public String hargaMinuman;
    public String infoMinuman;

    @Override
    public void tampilkanInfo() {
        System.out.println("Tampilan Info Pemesanan Minuman");
    }

    @Override
    void prosesPemesanan() {
        System.out.println("Proses Pemesanan Minuman");
    }
}
