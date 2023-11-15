import java.util.Scanner;

import Model.Layout;
import Model.Position;
import Model.Robot;

public class RobotApp {
    public static void main(String[] args){
        new RobotApp();
    }

    /*
     * Perintah Soal:
     * Anggap 'o' adalah sebuah robot yang berada didalam area permainan.
     * Buat robot dapat bergerak ke kiri/kanan/atas/bawah sesuai jumlah langkah yang diinstruksikan.
     * Format instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah} dan 'x' untuk keluar aplikasi *case sensitive
     * Robot tidak boleh keluar dari area permainan dan buat pesan kesalahannya.
     * Buat pesan kesalahan jika pengguna tidak menulis instruksi dengan benar.
     * Lanjut pada perintah soal dibawah.
     */

    private Layout layout;
    private Robot robot;
    private Scanner scanner;
    public RobotApp() {
        // contoh konfigurasi (inisiasi object layout) area permainan: X = 10, Y = 10, icon area yang tidak ditempati robot adalah '*'
        this.layout = new Layout(10, 10, '*');
        this.scanner = new Scanner(System.in);

        // inisialisasi posisi
        Position initposisi = new Position(5, 4);
        this.robot = new Robot('o', initposisi);

        String instruction = "";
        System.out.println("-------- Permainan Dimulai --------");
        do{
            draw();
            instruction = waitInstruction();

            //inisialisasi berapa langkah jalan dan arah jalan
            int langkahjalan = 0;
            String arahjalan = instruction.substring(0,1);
            if (instruction != null && !instruction.equals("x")) {
                langkahjalan = Integer.parseInt(instruction.substring(1));
            }
            else{
                System.out.println("Keluar dari aplikasi karena perintah invalid.");
            }


            if (robot.getPosition().getX() >= 0 && robot.getPosition().getX() + langkahjalan < layout.getMaxX() && robot.getPosition().getY() >= 0 && robot.getPosition().getY() + langkahjalan < layout.getMaxY()) {
                switch (arahjalan) {
                    case "w":
                        robot.getPosition().setY(robot.getPosition().getY() - langkahjalan);
                        break;
                    case "a":
                        robot.getPosition().setX(robot.getPosition().getX() - langkahjalan);
                        break;
                    case "s":
                        robot.getPosition().setY(robot.getPosition().getY() + langkahjalan);
                        break;
                    case "d":
                        robot.getPosition().setX(robot.getPosition().getX() + langkahjalan);
                        break;
                }
            } 
            else{
                System.out.println("Robot tidak boleh keluar dari area permainan.");
                break;
            }

        }while(!instruction.equals("x"));
        System.out.println("-------- Permainan Selesai --------");
    }

    private String waitInstruction() {
        System.out.println("-------- Instruksi --------");
        System.out.println("Instruksi: {d=kanan/a=kiri/w=atas/s=bawah}{jumlah langkah}");
        System.out.println("Contoh: w3 berarti 'keatas 3 langkah'");
        System.out.print("Masukan instruksi: ");
        return scanner.nextLine();
    }

    private void draw() {
        System.out.println("------ Posisi Terbaru ------");
        /*
        Gambar layout:
        Contoh:
        - Posisi robot di 1,1
        - Area permainan luasnya 10,10
        sehingga gambar layout akan menjadi:

            o*********
            **********
            **********
            **********
            **********
            **********
            **********
            **********
            **********
            **********
        */
        int robotY = robot.getPosition().getY();
        int robotX = robot.getPosition().getX();
        

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(i == robotY &&  j == robotX){
                    System.out.print(robot.getIcon());
                }
                else{
                    System.out.print(layout.getArea()[i][j]);
                }
            }
            System.out.println();
        }
        /* 
            - konfigurasi (icon robot, posisi robot, luas area dan icon area permainan yang tidak ditempati robot) silahkan gunakan prinsip OOP
            - icon cukup menggunakan karakter yang ada di keyboard.
         */
        

    }
}