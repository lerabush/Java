package fifth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task4 {
    private static final String OK_FILEPATH = "src/main/resources/ok.txt";
    private static final String ERROR_FILEPATH = "src/main/resources/error.txt";

    private static double sum;

    public static void main(String[] args) {
        printSumOfValues(OK_FILEPATH);
        printSumOfValues(ERROR_FILEPATH);
        printSumOfValues("not file");
    }

    private static int readValues(String fileName, List<Double> numbers) {
        File file = new File(fileName);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                numbers.add(Double.parseDouble(sc.next()));
            }
            return 0;
        } catch (FileNotFoundException ex) {
            return -1;
        } catch (NumberFormatException ex) {
            return -2;
        }
    }

    private static int sumOfValues(String fileName) {
        List<Double> nums = new ArrayList<>();
        int res = readValues(fileName, nums);
        if (res == 0) {
            for (double num : nums) {
                sum += num;
            }
        }
        return res;
    }

    public static void printSumOfValues(String fileName) {
        int resultCode = sumOfValues(fileName);
        switch (resultCode) {
            case 0:
                System.out.println("Program finished successfully, sum is " + sum);
                break;
            case -1:
                System.out.println("Program finished with error code -1: file wasn't found");
                break;
            case -2:
                System.out.println("Program finished with error code -2: " +
                        "not all lines in file are double numbers");
                break;
        }
    }
}

