package first;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("Max: ");
        int max = a > b ? (a > c ? a : c) : (b > c ? b : c);

        System.out.println(max);
        System.out.println(a > b ? (Math.max(a, c)) : (Math.max(b, c)));

    }


}
