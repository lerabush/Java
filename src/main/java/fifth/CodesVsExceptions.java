package fifth;

import fourth.Task11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static fifth.Task1_2_3.printSumOfValuesFromFile;
import static fifth.Task4.printSumOfValues;
import static java.lang.Double.parseDouble;

public class CodesVsExceptions {
    public static void main(String[] args) {
        long startTime1 = System.nanoTime();
        for (long i = 0; i < 1000000; i++) {
            try{
                testExceptions("src/main/java/fifth/ou.txt");
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        long time1 = System.nanoTime() - startTime1;
        long startTime2 = System.nanoTime();
        for (long i = 0; i < 1000000; i++) {
            int c = testErrorCodes("src/main/java/fifth/ou.txt");
            switch(c){
                case -1:
                    System.out.println("File not found");
                    break;
                case -2:
                    System.out.println("Incorrect number input");
                    break;
            }
        }
        long time2 = System.nanoTime() - startTime2;
        System.out.println(time1);
        System.out.println(time2);

        /*long startTime1 = System.nanoTime();
        for (long i = 0; i < 1000000; i++) {
            printSumOfValuesFromFile("src/main/java/fifth/out.txt");
        }
        long time1 = System.nanoTime() - startTime1;
        long startTime2 = System.nanoTime();
        for (long i = 0; i < 1000000; i++) {
          printSumOfValues("src/main/java/fifth/out.txt");
        }
        long time2 = System.nanoTime() - startTime2;
        System.out.println(time1);
        System.out.println(time2);*/
    }

    private static void testExceptions(String fileName) throws FileNotFoundException {
        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNext()) {
                parseDouble(scan.next());
            }
        }
    }

    private static int testErrorCodes(String fileName) {
        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNext()) {
                parseDouble(scan.next());
            }
        } catch (FileNotFoundException ex) {
            return -1;
        } catch (NumberFormatException ex) {
            return -2;
        }
        return 0;
    }
}
