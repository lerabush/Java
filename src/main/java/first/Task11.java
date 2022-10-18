package first;

import java.nio.charset.StandardCharsets;

public class Task11 {
    public static void main(String[] args) {
        String test = "¢©±Réal₽";
        isAscii(test);
        test = "Real";
        isAscii(test);
    }

    private static void isAscii(String v) {
        for (char sym : v.toCharArray()) {
            if (!StandardCharsets.US_ASCII.newEncoder().canEncode(sym)) {
                System.out.println(sym + " , in Unicode: " + (int) sym);
            }
        }


    }
}
