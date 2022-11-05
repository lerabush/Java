package fifth;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Task7_1{
    public static void main(String[] args) throws Exception {
        try (Scanner fs = new Scanner(new File("src/main/java/fifth/ру.pdf"))) {
            for(int i=0;i<5;i++){
                System.out.println(fs.next());//clean buff
                long j = 0;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}