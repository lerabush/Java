package first;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int angle = scanner.nextInt();
        System.out.println(Math.abs(angle)%360);
        System.out.println(Math.floorMod(Math.abs(angle),360));
    }
}
