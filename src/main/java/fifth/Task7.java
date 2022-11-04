package fifth;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.CharBuffer;
import java.util.Scanner;


public class Task7 {
    public static void main(String[] args) throws Exception {
        Scanner in1 = null;
        try (FileInputStream fs = new FileInputStream("src/main/java/fifth/hello.jpg")) {
            in1 = new Scanner(fs);

            for(int i=0;i<10;i++){
                System.out.println(in1.next());//clean buff
                long j = 0;
                while(j!=10000000000L){
                    j++;
                }
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
