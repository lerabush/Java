package first;

import java.math.BigInteger;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(factorial(n).toString());

    }

    public static BigInteger factorial(int n) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
