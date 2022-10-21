package fifth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Task4 {
    public static Result<ArrayList<Double>, String> readValues(String filename) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File(filename));
        if (fileInputStream == null) {
            return Result.err(String.format("File %s not found!", filename));
        } else {
            Scanner scanner = new Scanner(fileInputStream);
            ArrayList<Double> values = new ArrayList<>();
            while (scanner.hasNext()) {
                String next = scanner.next();
                try {
                    values.add(Double.parseDouble(next));
                } catch (NumberFormatException e) {
                    return Result.err(String.format("%s is not a number", next));
                }
            }
            return Result.ok(values);
        }
    }

    public static Result<Double, String> sumOfValues(String filename) throws FileNotFoundException {
        Result<Double, String> result;
        Result<ArrayList<Double>, String> values = readValues(filename);
        if (values instanceof Ok) {
            Ok<ArrayList<Double>, String> ok = (Ok<ArrayList<Double>, String>) values;
            double sum = 0;
            for (Double value : ok.getValue()) {
                sum += value;
            }
            result = Result.ok(sum);
        } else {
            Error<ArrayList<Double>, String> err = (Error<ArrayList<Double>, String>) values;
            result = Result.err(err.getError());
        }
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Result<Double, String> result = sumOfValues("src/main/java/fifth/out.txt");
        Result<Double, String> result2 = sumOfValues("src/main/java/fifth/error.txt");
        System.out.println(((Ok<Double, String>) result).getValue());
        System.out.println(((Error<Double, String>) result2).getError());
    }
}

