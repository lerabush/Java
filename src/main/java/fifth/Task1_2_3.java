package fifth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1_2_3 {
    private static final String OK_FILEPATH = "src/main/java/fifth/out.txt";
    private static final String ERROR_FILEPATH = "src/main/java/fifth/error.txt";

    public static void main(String[] args) {
        long startTime1 = System.nanoTime();
        printSumOfValuesFromFile(OK_FILEPATH);
        long time = System.nanoTime() - startTime1;
        System.out.println(time);
        //Не все значения -  double
        long startTime2 = System.nanoTime();
        printSumOfValuesFromFile(ERROR_FILEPATH);
        long time2 = System.nanoTime() - startTime2;
        System.out.println(time2);
        //Файл не найден
        long startTime3 = System.nanoTime();
        printSumOfValuesFromFile("not.txt");
        long time3 = System.nanoTime() - startTime3;
        System.out.println(time3);

    }

    private static ArrayList<Double> readValues(String fileName) throws FileNotFoundException, NumberFormatException {
        try (Scanner scan = new Scanner(new File(fileName))) {
            ArrayList<Double> doubleList = new ArrayList<>();
            while (scan.hasNext()) {
                doubleList.add(Double.parseDouble(scan.next()));
            }
            return doubleList;
        }
    }

    private static double sumOfValues(String fileName) throws Exception {
        return readValues(fileName).stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public static void printSumOfValuesFromFile(String fileName) {
        try {
            double sum = sumOfValues(fileName);
            System.out.println("Result: "+sum);
            System.out.println("OK");
        } catch (IOException ex) {
            System.out.println("Result: null");
            System.out.println("Error with opening or reading file occured!");
        } catch(NumberFormatException ex){
            System.out.println("Result: null");
            System.out.println("Not all symbols are double values!");
        } catch (Exception ex){
            System.out.println("Result: null");
            System.out.println("Error ocurred while calculation");
        }

    }

}
