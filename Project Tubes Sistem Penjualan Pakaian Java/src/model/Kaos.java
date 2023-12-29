package model;

public class Kaos extends Item{
    private String namaKaos;
    private String warnaKaos; 
    private int jumlahKaos;
    private double hargaKaos;


    public Kaos(int idItem, String jenisPakaian, String namaKaos, String warnaKaos, int jumlahKaos, Double hargaKaos) {
        super(idItem, jenisPakaian);
        this.namaKaos = namaKaos;
        this.warnaKaos = warnaKaos;
        this.jumlahKaos = jumlahKaos;
        this.hargaKaos = hargaKaos;
    }

    
    public void setNamaKaos(String namaKaos){
        this.namaKaos = namaKaos;
    }
    public String getNamaKaos(){
        return namaKaos;
    }

    
    public void setWarnaKaos(String warnaKaos){
        this.warnaKaos = warnaKaos;
    }
    public String getWarnaKaos(){
        return warnaKaos;
    }


    public void setJumlahKaos(int jumlahKaos){
        this.jumlahKaos = jumlahKaos;
    }
    public int getJumlahKaos(){
        return jumlahKaos;
    }


    public void setHargaKaos(double hargaKaos){
        this.hargaKaos = hargaKaos;
    }
    public double getHargaKaos(){
        return hargaKaos;
    }


    @Override
    public void setAttributes(String nama, String warna, int jumlah, double harga) {
        setNamaKaos(nama);
        setWarnaKaos(warna);
        setJumlahKaos(jumlah);
        setHargaKaos(harga);
    }

    @Override
    public String getNama() {
        return namaKaos;
    }

    @Override
    public double getHarga() {
        return hargaKaos;
    }
    @Override
    public int getStok() {
        return jumlahKaos;
    }
    @Override
    public String information() {
        return super.information() + "\n| Nama Kaos : " + namaKaos + "\n| Warna Kaos : " + warnaKaos + "\n| Jumlah Kaos : " + jumlahKaos + "\n| Harga Kaos : " + hargaKaos;
    }
}
