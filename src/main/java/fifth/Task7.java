package fifth;

import java.io.*;
import java.util.Scanner;


public class Task7 {
    public static void main(String[] args) throws Exception {
        //try c ресурсами
        Scanner sc = null;
        try{
            sc = new Scanner(new File("src/main/java/fifth/hello.txt"));
            System.out.println(sc.next());
        }catch (Exception ex){
            try{
                throw new IOException("error while working!");
            }catch (Exception ex1){
                System.out.println(sc.ioException());
            }

        }

        try (Scanner in1 = new Scanner(new File("src/main/resources/notfound.txt"))) {
            while (in1.hasNext()) {
                System.out.println(in1.next());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
/*
если возникает исключение, оно сохраняется в lastException, тогда есть геттер с именем ioException(), который
возвращает это исключение. Это отличается от подавления исключений путем встраивания его в другое, потому что это в основном
сохранение исключения и его удаление, чтобы пользователь мог получить его позже.
 */
