import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHelper {
    private String namaFileDataMahasiswa = "data_mahasiswa.txt";

    public void simpanKeFile(ArrayList<Mahasiswa> daftarMahasiswa){
        try (PrintWriter writer = new PrintWriter(new File(namaFileDataMahasiswa))){
            for (Mahasiswa m : daftarMahasiswa){
                writer.println(m.getNim() + "," + m.getNama() + "," + m.getJenisKelamin() + "," + m.getUsia() + "," + m.getEmail());
            }
        }
        catch (IOException e){
            System.out.println("Terjadi kesalahan saat menyimpan file: " + e.getMessage());
        }
    }

    public ArrayList<Mahasiswa> bacaDariFile(){
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(namaFileDataMahasiswa))){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String [] parts = line.split(",");
                if (parts.length == 5){
                    Mahasiswa m = new Mahasiswa(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    daftarMahasiswa.add(m);
                }
            }
        }
        catch (IOException e){
            
        }
        return daftarMahasiswa;
    }

    public void clearFileContent() {
        try (FileWriter writer = new FileWriter(namaFileDataMahasiswa, false)) {
            System.out.println("Data file sudah terhapus: " + namaFileDataMahasiswa);
        } catch (IOException e) {
            System.out.println("Gagal untuk menghapus data file: " + e.getMessage());
        }
    }

    public String getNamaFileDataMahasiswa() {
        return namaFileDataMahasiswa;
    }

    public void gantiNamaFile(String namaBaru) {
        File fileLama = new File(namaFileDataMahasiswa);
        File fileBaru = new File(namaBaru);

        if (fileLama.exists()) {
            if (fileBaru.exists()) {
                System.out.println("File dengan nama baru sudah ada. Gagal mengganti nama file.");
            } else {
                try {
                    Files.copy(fileLama.toPath(), fileBaru.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    if (fileLama.delete()) {
                        System.out.println("Nama file berhasil diganti menjadi: " + namaBaru);
                        namaFileDataMahasiswa = namaBaru;
                    } else {
                        System.out.println("Gagal menghapus file lama.");
                    }
                } catch (IOException e) {
                    System.out.println("Gagal mengganti nama file: " + e.getMessage());
                }
            }
        } else {
            System.out.println("File lama tidak ditemukan: " + namaFileDataMahasiswa);
        }
    }   
}
