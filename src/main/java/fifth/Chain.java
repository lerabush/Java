package fifth;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Chain {

    public static void method() throws FileFormatException {
        Scanner sc = new Scanner("chain.txt");
        try {
            int i = sc.nextInt();
        } catch (InputMismatchException ex) {
            throw new FileFormatException("Файл содержит некорректные данные: Ожидаются целые числа!", ex);
        }
    }

    public static void main(String[] args) throws FileFormatException {
        method();
    }
}
