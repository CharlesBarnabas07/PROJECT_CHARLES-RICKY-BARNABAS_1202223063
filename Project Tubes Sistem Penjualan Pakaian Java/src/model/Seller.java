package model;

public class Seller {
    //initiate tipe data
    private int idSeller;
    private String namaSeller;
    private String emailSeller;
    private String password;

    //initiate seller constructor 
    public Seller(int idSeller, String namaSeller, String emailSeller, String password) {
        this.idSeller = idSeller;
        this.namaSeller = namaSeller;
        this.emailSeller = emailSeller;
        this.password = password;
    }

    //setter getter id seller
    public void setIdSeller(int idSeller) {
        this.idSeller = idSeller;
    }

    public int getIdSeller() {
        return idSeller;
    }

    //setter getter nama seller
    public void setNamaSeller(String namaSeller) {
        this.namaSeller = namaSeller;
    }

    public String getNamaSeller() {
        return namaSeller;
    }

    //setter getter email
    public void setEmailSeller(String emailSeller) {
        this.emailSeller = emailSeller;
    }

    public String getEmailSeller() {
        return emailSeller;
    }

    //setter getter password
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    //after signup
    public void RegisterSellerMember() {
        System.out.println("\n-------------------------------------------");
        System.out.println("| Sign Up Seller Berhasil!");
        System.out.println("| Id : " + idSeller);
        System.out.println("| Nama : " + namaSeller);
        System.out.println("| Email : "+ emailSeller);
        System.out.println("-------------------------------------------");
    }
}
