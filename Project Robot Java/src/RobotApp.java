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
        String instruction = "";
        System.out.println("-------- Permainan Dimulai --------");
        draw();
        do{
            instruction = waitInstruction();
            String direction = instruction.substring(0, 1);
            int step = 0;
            if (!(instruction.equals("x"))) {
                step = Integer.parseInt(instruction.substring(1)); 
            }

            if (direction.equals("d")) {
                robot.setPosition(new Position(robot.getPosition().getX() + step, robot.getPosition().getY()));
            } else if (direction.equals("a")) {
                robot.setPosition(new Position(robot.getPosition().getX() - step, robot.getPosition().getY()));
            } else if (direction.equals("w")) {
                robot.setPosition(new Position(robot.getPosition().getX(), robot.getPosition().getY() - step));
            } else if (direction.equals("s")) {
                robot.setPosition(new Position(robot.getPosition().getX(), robot.getPosition().getY() + step));
            } else {
                System.out.println("Instruksi tidak dikenali, permainan selesai");
            }

            if (robot.getPosition().getX() < 0 || robot.getPosition().getX() > layout.getMaxX() - 1 || robot.getPosition().getY() < 0 || robot.getPosition().getY() > layout.getMaxY() - 1) {
                System.out.println("Robot keluar dari area permainan, permainan selesai");
                break;
            }

            System.out.println("------ Posisi Terbaru ------");
            //set robot position and erase previous position
            for (int y = 0; y < layout.getMaxY(); y++) {
                for (int x = 0; x < layout.getMaxX(); x++) {
                    if (x == robot.getPosition().getX() && y == robot.getPosition().getY()) {
                        System.out.print(robot.getIcon());
                    } else {
                        System.out.print(layout.getArea()[x][y]);
                    }
                }
                System.out.println();
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
        System.out.println("------ Posisi Awal ------");
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

            - konfigurasi (icon robot, posisi robot, luas area dan icon area permainan yang tidak ditempati robot) silahkan gunakan prinsip OOP
            - icon cukup menggunakan karakter yang ada di keyboard.
         */

        // contoh konfigurasi (inisiasi object robot) posisi awal robot: 1,1

        this.robot = new Robot('o', new Position(0, 0));

        for (int y = 0; y < layout.getMaxY(); y++) {
            for (int x = 0; x < layout.getMaxX(); x++) {
                if (x == robot.getPosition().getX() && y == robot.getPosition().getY()) {
                    System.out.print(robot.getIcon());
                } else {
                    System.out.print(layout.getArea()[x][y]);
                }
            }
            System.out.println();
        }


    }
}