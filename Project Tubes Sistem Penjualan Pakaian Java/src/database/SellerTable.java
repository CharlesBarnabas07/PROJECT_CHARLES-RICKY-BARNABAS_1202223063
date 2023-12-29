package database;

import java.util.ArrayList;
import model.Chinos;
import model.Jaket;
import model.Kaos;

public class SellerTable {
    private ArrayList<Chinos> listChinos;
    private ArrayList<Jaket> listJaket;
    private ArrayList<Kaos> listKaos;

    public SellerTable() {
        this.listChinos = new ArrayList<>();
        this.listJaket = new ArrayList<>();
        this.listKaos = new ArrayList<>();
    }

    public ArrayList<Chinos> getListChinos() {
        return listChinos;
    }

    public ArrayList<Jaket> getListJaket() {
        return listJaket;
    }

    public ArrayList<Kaos> getListKaos() {
        return listKaos;
    }
}
