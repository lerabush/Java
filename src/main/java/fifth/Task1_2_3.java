package fifth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1_2_3 {
    private static final String OK_FILEPATH = "src/main/resources/ok.txt";
    private static final String ERROR_FILEPATH = "src/main/resources/error.txt";

    public static void main(String[] args) {
        printSumOfValuesFromFile(OK_FILEPATH);
        printSumOfValuesFromFile(ERROR_FILEPATH);
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
            System.out.println(sumOfValues(fileName));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Error with opening or reading file occured!");
        } catch(NumberFormatException ex){
            ex.printStackTrace();
            System.err.println("Not all symbols are double values!");
        } catch (Exception ex){
            ex.printStackTrace();
            System.err.println("Error ocurred");
        }

    }

}
