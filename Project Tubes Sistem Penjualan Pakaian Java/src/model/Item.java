package model;

public abstract class Item {
    private int idItem;
    private String jenisPakaian;
    private int jumlahBeli;
    public abstract String getNama();
    public abstract double getHarga();
    public abstract int getStok();

    
    public Item(int idItem, String jenisPakaian) {
        this.idItem = idItem;
        this.jenisPakaian = jenisPakaian;
    }


    public void setIdItem(int idItem){
        this.idItem = idItem;
    }
    public int getIdItem(){
        return idItem;
    }


    public void setJenisPakaian(String jenisPakaian){
        this.jenisPakaian = jenisPakaian;
    }
    public String getJenisPakaian(){
        return jenisPakaian;
    }


    public int getJumlahBeli() {
        return jumlahBeli;
    }
    public void setJumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
    }

    
    public String information(){
        return "| Id Item : " + idItem + "\n| Jenis Pakaian: " + jenisPakaian;  
    }


    public abstract void setAttributes(String nama, String warna, int jumlah, double harga);
}
