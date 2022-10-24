package fifth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Task4 {
    public static Result<ArrayList<Double>> readValues(String filename) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File(filename));
        if (fileInputStream == null) {
            return new Result(-1,String.format("File %s not found!",filename),null);
        } else {
            Scanner scanner = new Scanner(fileInputStream);
            ArrayList<Double> values = new ArrayList<>();
            while (scanner.hasNext()) {
                String next = scanner.next();
                try {
                    values.add(Double.parseDouble(next));
                } catch (NumberFormatException e) {
                    return new Result(-2,String.format("%s is not a number", next),null);
                }
            }
            return new Result(0,"OK",values);
        }
    }

    public static Result<Double> sumOfValues(String filename) throws FileNotFoundException {
        Result<Double> result;
        Result<ArrayList<Double>> values = readValues(filename);
        if (values.getErrorCode()==0) {
            double sum = 0;
            for (Double value : values.getResult()) {
                sum += value;
            }
            result = new Result(0,"OK",sum);
        } else {
            result = new Result(values.getErrorCode(),values.getErrorMessage(),null);
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime1 = System.nanoTime();
        Result<Double> result = sumOfValues("src/main/java/fifth/out.txt");
        long time = System.nanoTime() - startTime1;
        long startTime2 = System.nanoTime();
        Result<Double> result2 = sumOfValues("src/main/java/fifth/error.txt");
        long time2 = System.nanoTime() - startTime2;
        System.out.println(result.getResult());
        System.out.println(result.getErrorCode());
        System.out.println(result.getErrorMessage());
        System.out.println(time);
        System.out.println("--------");
        System.out.println(result2.getResult());
        System.out.println(result2.getErrorCode());
        System.out.println(result2.getErrorMessage());
        System.out.println(time2);

    }
}

