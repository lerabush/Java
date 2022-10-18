package fifth;

import java.awt.desktop.ScreenSleepEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExceptionsVsCodes {
    public static void main(String[] args) {
        calc();
        calcWithCodes();
    }

    public static int checkOperation(String operation) {
        switch (operation) {
            case "+":
            case "/":
            case "*":
            case "-":
                return 1;
            default:
                return 0;
        }
    }

    public static double calcResultByOperation(String operation, List<Integer> operands) {
        try {
            switch (operation) {
                case "+":
                    return (double) operands.get(0)+operands.get(1);
                case "/":
                    return (double) operands.get(0)/operands.get(1);
                case "*":
                    return (double) operands.get(0)*operands.get(1);
                case "-":
                    return (double) operands.get(0)-operands.get(1);
            }
        } catch (RuntimeException ex) {
            return -2;
        }
        return 0;
    }

    public static void calcWithCodes() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> ab = inputOperands(scanner);
        if (ab == null) {
            System.out.println("Программа неудачно завершилась:( Введенные числа не соответствуют ожидаемому типу");
            System.out.println("Bye!");
            return;
        }
        System.out.println("Enter operation: ");
        String operation = scanner.next();
        double code = checkOperation(operation);
        if (code != 1) {
            System.out.println("Программа неудачно завершилась:( Код ошибки: " + code);
            return;
        }
        double result = calcResultByOperation(operation,ab);
        System.out.println(result);
        System.out.println("Bye!");
    }

    public static List<Integer> inputOperands(Scanner sc) {
        try {
            System.out.println("Enter first operand: ");
            int a = Integer.parseInt(sc.next());
            System.out.println("Enter second operand: ");
            int b = Integer.parseInt(sc.next());
            List<Integer> operands = new ArrayList<>(2);
            operands.add(a);
            operands.add(b);
            return operands;
        } catch (NumberFormatException ex) {
            return null;
        }

    }

    public static void calc() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first operand: ");
        try {
            int a = Integer.parseInt(scanner.next());
            System.out.println("Enter second operand: ");
            int b = Integer.parseInt(scanner.next());
            System.out.println("Enter operation: ");
            String operation = scanner.next();
            double result;
            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = (double) a / b;
                    break;
                default:
                    throw new NoSuchOperationException(operation);
            }
            System.out.println(result);
        } catch (NoSuchOperationException | RuntimeException ex) {
            System.err.println("Программа неудачно выполнилась: " + ex.getMessage());
        } finally {
            System.out.println("bye!");
        }
    }
}
