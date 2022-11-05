package fifth;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.CharBuffer;
import java.util.Scanner;


public class Task7 {
    public static void main(String[] args) throws Exception {
        Scanner in1 = null;
        try (FileInputStream fs = new FileInputStream("src/main/java/fifth/hello.txt")) {
            in1 = new Scanner(fs);
            for(int i=0;i<20;i++){
                System.out.println(in1.next());//clean buff
                long j = 0;
                while(j!=2){
                    j++;
                    if(j==2) throw new IOException("oops");
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            in1.close();
        }
    }
}
/*
если возникает исключение, оно сохраняется в lastException, тогда есть геттер с именем ioException(), который
возвращает это исключение. Это отличается от подавления исключений путем встраивания его в другое, потому что это в основном
сохранение исключения и его удаление, чтобы пользователь мог получить его позже.
 */
