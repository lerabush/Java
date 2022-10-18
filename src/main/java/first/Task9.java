package first;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Task9 {
    public static void main(String[] args) {
        String test = "Réal";
        System.out.println(test + " isPureAscii() : " + isPureAscii(test));
        test = "Real";
        System.out.println(test + " isPureAscii() : " + isPureAscii(test));
    }

    private static boolean isPureAscii(String v) {
        return StandardCharsets.US_ASCII.newEncoder().canEncode(v);

    }
}
