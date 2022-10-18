package third;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class Task12 {
    private static String DIR = "C:\\Users\\mi\\Downloads\\Telegram Desktop";

    public static void main(String[] args) {
        File[] files = new File(DIR).listFiles();
        sort(files);
        for(File file: files){
            System.out.println(file);
        }
    }

    private static void sort(File[] files) {
        Arrays.sort(files, Comparator.comparing(File::isFile).thenComparing(File::getPath));
    }
}
