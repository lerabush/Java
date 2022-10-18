package first;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println(Integer.toString(a,2));
        System.out.println(Integer.toString(a,8));
        System.out.println(Integer.toString(a,16));
        System.out.println(Double.toHexString((double)1/a));

    }
}
