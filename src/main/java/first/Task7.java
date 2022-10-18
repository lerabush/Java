package first;

import java.util.Random;
import java.util.Scanner;




public class Task7 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        short s1 = (short) scanner.nextInt();
        short s2 = (short) scanner.nextInt();
        System.out.println("first = " + Short.toUnsignedInt(s1));
        System.out.println("second = " + Short.toUnsignedInt(s2));
        System.out.println("sum = " + (Short.toUnsignedInt(s1) + Short.toUnsignedInt(s2)));
        System.out.println("sub= " + (Short.toUnsignedInt(s1) - Short.toUnsignedInt(s2)));
        System.out.println("mult = " + (Short.toUnsignedInt(s1) * Short.toUnsignedInt(s2)));
        System.out.println("div = " + (Short.toUnsignedInt(s1) / Short.toUnsignedInt(s2)));
        System.out.println("mod = " + (Short.toUnsignedInt(s1) % Short.toUnsignedInt(s2)));
    }
}
