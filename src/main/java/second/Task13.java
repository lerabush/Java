package second;

import java.io.FileReader;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class Task13 {
    public static void main(String[] args) throws Exception {
        try (FileReader reader = new FileReader("src/main/resources/test.csv");
             CSVReader csvReader = new CSVReader(reader)) {
            csvReader.readAll().stream().limit(10).map(Arrays::toString).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
