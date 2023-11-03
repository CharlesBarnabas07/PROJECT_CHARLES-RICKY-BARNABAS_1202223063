import java.util.Scanner;

import Model.Layout;
import Model.Position;
import Model.Robot;

public class RobotApp {
    public static void main(String[] args){
        new RobotApp();
    }

    private Layout layout;
    private Robot robot;
    private Scanner scanner;

    public RobotApp() {
        this.layout = new Layout(10, 10, '*');
        this.robot = new Robot('o', new Position(1, 1)); // Posisi awal robot: 1,1
        this.scanner = new Scanner(System.in);

        System.out.println("-------- Permainan Dimulai --------");

        String instruction;
        do {
            draw();
            instruction = waitInstruction();
            processInstruction(instruction);
        } while (!robotIsOutside() && !instruction.equals("x"));
        System.out.println("-------- Permainan Selesai --------");
    }

    private void processInstruction(String instruction) {
        char direction = instruction.charAt(0);
        int steps = Integer.parseInt(instruction.substring(1));

        switch (direction) {
            case 'd':
                moveRobot(steps, 0);
                break;
            case 'a':
                moveRobot(-steps, 0);
                break;
            case 'w':
                moveRobot(0, -steps);
                break;
            case 's':
                moveRobot(0, steps);
                break;
            default:
                System.out.println("Instruksi tidak valid, permainan selesai");
        }
    }

    private void moveRobot(int deltaX, int deltaY) {
        Position currentPosition = robot.getPosition();
        int newX = currentPosition.getX() + deltaX;
        int newY = currentPosition.getY() + deltaY;

        robot.setPosition(new Position(newX, newY));
    }

    private boolean robotIsOutside() {
        Position position = robot.getPosition();
        return position.getX() < 0 || position.getX() >= layout.getMaxX() ||
               position.getY() < 0 || position.getY() >= layout.getMaxY();
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
