package fifth;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Task5 {
    private static final String OK_FILEPATH = "src/main/resources/ok.txt";
    private static final String OUT_FILEPATH = "src/main/resources/out.txt";


    public static void main(String[] args) {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get(OK_FILEPATH));
            out = new PrintWriter(OUT_FILEPATH);
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            close(in);
            close(out);
        }
    }

    private static void close(Closeable out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
