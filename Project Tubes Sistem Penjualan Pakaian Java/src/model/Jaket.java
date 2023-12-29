package model;

public class Jaket extends Item{
    private String namaJaket;
    private String warnaJaket;  
    private int jumlahJaket;
    private double hargaJaket;


    public Jaket(int idItem, String jenisPakaian, String namaJaket, String warnaJaket, int jumlahJaket, Double hargaJaket) {
        super(idItem, jenisPakaian);
        this.namaJaket = namaJaket;
        this.warnaJaket = warnaJaket;
        this.jumlahJaket = jumlahJaket;
        this.hargaJaket = hargaJaket;
    }
    

    public void setNamaJaket(String namaJaket){
        this.namaJaket = namaJaket;
    }
    public String getNamaJaket(){
        return namaJaket;
    }


    public void setWarnaJaket(String warnaJaket){
        this.warnaJaket = warnaJaket;
    }
    public String getWarnaJaket(){
        return warnaJaket;
    }


    public void setJumlahJaket(int jumlahJaket){
        this.jumlahJaket = jumlahJaket;
    }
    public int getJumlahJaket(){
        return jumlahJaket;
    }


    public void setHargaJaket(double hargaJaket){
        this.hargaJaket = hargaJaket;
    }
    public double getHargaJaket(){
        return hargaJaket;
    }


    @Override
    public void setAttributes(String nama, String warna, int jumlah, double harga) {
        setNamaJaket(nama);
        setWarnaJaket(warna);
        setJumlahJaket(jumlah);
        setHargaJaket(harga);
    }


    @Override
    public String getNama() {
        return namaJaket;
    }
    @Override
    public double getHarga() {
        return hargaJaket;
    }
    @Override
    public int getStok() {
        return jumlahJaket;
    }

    @Override
    public String information() {
        return super.information() + "\n| Nama Jaket : " + namaJaket + "\n| Warna Jaket : " + warnaJaket + "\n| Jumlah Jaket : " + jumlahJaket + "\n| Harga Jaket : " + hargaJaket;
    }
}
