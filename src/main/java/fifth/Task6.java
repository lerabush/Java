package fifth;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class Task6 {
    private static final String OK_FILEPATH = "src/main/resources/ok.txt";

    public static void main(String[] args) {
        first(OK_FILEPATH);
        second(OK_FILEPATH);
        third(OK_FILEPATH);
    }

    private static void first(String filePath) {
        BufferedReader in = null;
        try {
            in = Files.newBufferedReader(Path.of(filePath), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            close(in);
        }
    }

    private static void second(String filePath) {
        BufferedReader in = null;
        try {
            try {
                in = Files.newBufferedReader(Path.of(filePath), StandardCharsets.UTF_8);
            } finally {
                if (in != null) {
                    in.close();
                }
            }

        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }
    }
    private static void third(String filePath){
        try(BufferedReader in = Files.newBufferedReader(Path.of(filePath), StandardCharsets.UTF_8)){
            //read
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static void close(Closeable in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
