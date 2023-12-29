package model;

public class Chinos extends Item {
    private String namaChinos;
    private String warnaChinos;
    private int jumlahChinos;
    private double hargaChinos;
    

    public Chinos(int idItem, String jenisPakaian, String namaChinos, String warnaChinos, int jumlahChinos, Double hargaChinos) {
        super(idItem, jenisPakaian);
        this.namaChinos = namaChinos;
        this.warnaChinos = warnaChinos;
        this.jumlahChinos = jumlahChinos;
        this.hargaChinos = hargaChinos;     
    }


    public void setNamaChinos(String namaChinos) {
        this.namaChinos = namaChinos;
    }
    public String getNamaChinos() {
        return namaChinos;
    }


    public void setWarnaChinos(String warnaChinos) {
        this.warnaChinos = warnaChinos;
    }
    public String getWarnaChinos() {
        return warnaChinos;
    }


    public void setJumlahChinos(int jumlahChinos) {
        this.jumlahChinos = jumlahChinos;
    }
    public int getJumlahChinos() {
        return jumlahChinos;
    }


    public void setHargaChinos(double hargaChinos) {
        this.hargaChinos = hargaChinos;
    }
    public double getHargaChinos() {
        return hargaChinos;
    }


    @Override
    public void setAttributes(String nama, String warna, int jumlah, double harga) {
        setNamaChinos(nama);
        setWarnaChinos(warna);
        setJumlahChinos(jumlah);
        setHargaChinos(harga);
    }


    @Override
    public String getNama() {
        return namaChinos;
    }
    @Override
    public double getHarga() {
        return hargaChinos;
    }
    @Override
    public int getStok() {
        return jumlahChinos;
    }

    
    @Override
    public String information() {
        return super.information() + "\n| Nama Chinos : " + namaChinos + "\n| Warna Chinos : " + warnaChinos +"\n| Jumlah Chinos : " + jumlahChinos + "\n| Harga Chinos : " + hargaChinos ;
    }
}
