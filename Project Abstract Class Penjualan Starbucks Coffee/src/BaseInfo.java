public abstract class BaseInfo {
    public String namaPelayan;
    public String waktuPemesanan;
    public int nomorPesanan;

    public void tampilkanInfo() {
        System.out.println("Tampilan Info Pemesanan");
    }

    abstract void prosesPemesanan();
}
