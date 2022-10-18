package first;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("hh");
        StringBuilder a = s;
        s.append("hello");
        System.out.println(a.toString());
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.trim().split("\\s+");
        for(String i: strings) System.out.println(i);
    }
}
