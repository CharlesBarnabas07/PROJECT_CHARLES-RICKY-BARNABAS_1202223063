public class Mahasiswa {

    private String nim;
    private String nama;
    private String jeniskelamin;
    private String usia;
    private String email;

    public Mahasiswa (String nim, String nama, String jeniskelamin, String usia, String email) {

        this.nama = nama;
        this.nim = nim;
        this.jeniskelamin = jeniskelamin;
        this.usia = usia;
        this.email = email;
    }

    public String getNim() {
        return nim;
    }
    public String getNama() {
        return nama;
    }
    public String getJenisKelamin() {
        return jeniskelamin;
    }
    public String getUsia() {
        return usia;
    }
    public String getEmail(){
        return email;
    }

}