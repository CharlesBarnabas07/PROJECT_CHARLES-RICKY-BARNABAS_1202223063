import java.util.Scanner;
public class totalnilaimahasiswa {
    public static void main (String[] args){
        Scanner inputan = new Scanner(System.in);
        hitungtotalnilaimahasiswa hitungnilaisir = new hitungtotalnilaimahasiswa();
        
        System.out.print("Masukkan Nama mu : ");
        String nama = inputan.nextLine();
        System.out.print("Masukkan Nim mu: ");
        int nim = inputan.nextInt();
        System.out.print("Nilai Tubes mu berapa?: ");
        double nilaitubesmu = inputan.nextDouble();
        System.out.print("Nilai Quiz mu berapa?: ");
        double nilaiquizmu = inputan.nextDouble();
        System.out.print("Nilai Tugas mu berapa?: ");
        double nilaitugasmu = inputan.nextDouble();
        System.out.print("Nilai UTS mu berapa?: ");
        double nilaiutsmu = inputan.nextDouble();
        System.out.print("Nilai UAS mu berapa?: ");
        double nilaiuasmu = inputan.nextDouble();

        System.out.println("\nNama : " + nama);
        System.out.println("Nim : " + nim);
        System.out.println("Nilai Mata Kuliah Pemrograman Berorientasi Objek : " + hitungnilaisir.hitungnilaimu(nilaitubesmu, nilaiquizmu, nilaitugasmu, nilaiutsmu, nilaiuasmu));
    }
}