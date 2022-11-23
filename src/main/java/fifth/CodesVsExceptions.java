package fifth;

import java.util.Scanner;

public class CodesVsExceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String c = scanner.nextLine();
        long startTime1 = System.nanoTime();
        for (long i = 0; i < 10000; i++) {
            try{
                checkIfEqualsHello1(c);
            }catch (Exception ex){
                //System.out.println(ex.getMessage());
            }

        }
        long time1 = System.nanoTime() - startTime1;
        long startTime2 = System.nanoTime();
        for (long i = 0; i < 10000; i++) {
            int n = checkIfEqualsHello(c);
            switch (n) {
                case -1:
                    //System.out.println("Incorrect string");
                    break;
                case -2:
                   // System.out.println("Empty string");
                    break;
            }
        }
        long time2 = System.nanoTime() - startTime2;
        System.out.println(time1);
        System.out.println(time2);
    }

    private static void checkIfEqualsHello1(String c) throws Exception {
        if (c.isBlank()) throw new EmptyStringException("Empty string");
        if (!c.equalsIgnoreCase("hello")) {
            throw new IncorrectStringException("Incorrect string");
        }

    }

    private static int checkIfEqualsHello(String c) {
        if (c.isBlank()) return -2;
        if (!c.equalsIgnoreCase("hello")) {
            return -1;
        }
        return 0;
    }

    private static class EmptyStringException extends Exception {
        public EmptyStringException(String s) {
            super(s);
        }
    }

    private static class IncorrectStringException extends Exception {
        public IncorrectStringException(String s) {
            super(s);
        }
    }
}
