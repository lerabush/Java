package fifth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class Task4 {
    private static final String OK_FILEPATH = "src/main/java/fifth/out.txt";
    private static final String ERROR_FILEPATH = "src/main/java/fifth/error.txt";


    public static void main(String[] args) {
        long startTime1 = System.nanoTime();
        printSumOfValues(OK_FILEPATH);
        long time = System.nanoTime() - startTime1;
        System.out.println(time);
        //Не все значения -  double
        long startTime2 = System.nanoTime();
        printSumOfValues(ERROR_FILEPATH);
        long time2 = System.nanoTime() - startTime2;
        System.out.println(time2);
        //Файл не найден
        long startTime3 = System.nanoTime();
        printSumOfValues("not.txt");
        long time3 = System.nanoTime() - startTime3;
        System.out.println(time3);
    }

    private static Result<ArrayList<Double>> readValues(String filename) {
        try (Scanner scan = new Scanner(new File(filename))) {
            ArrayList<Double> doubleList = new ArrayList<>();
            while (scan.hasNext()) {
                String next = scan.next();
                try {
                    doubleList.add(Double.parseDouble(next));
                } catch (NumberFormatException e) {
                    return new Result(-2, null);
                }
            }
            return new Result(0, doubleList);
        } catch (IOException ex) {
            return new Result(-1, null);
        }
    }

    private static Result<Double> sumOfValues(String filename) {
        Result<Double> result;
        Result<ArrayList<Double>> values = readValues(filename);
        if (values.getErrorCode() == 0) {
            try {
                double sum = values.getResult().stream()
                        .mapToDouble(Double::doubleValue)
                        .sum();
                result = new Result(0, sum);
            } catch (Exception ex) {
                result = new Result(-3 , null);
            }

        } else {
            result = new Result(values.getErrorCode(), null);
        }
        return result;
    }
    public static void printSumOfValues(String fileName){
        Result<Double> result = sumOfValues(fileName);
        System.out.println("Result: "+result.getResult());
        switch(result.getErrorCode()){
            case 0:
                System.out.println("OK");
                break;
            case -1:
                System.out.println("Error with opening or reading file occured!");
                break;
            case -2:
                System.out.println("Not all symbols are double values!");
                break;
            case -3:
                System.out.println("Error ocurred while calculation");
                break;
        }
    }
}

