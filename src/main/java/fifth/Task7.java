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
            var fd = fs.getFD();
            Method method = fd.getClass().getDeclaredMethod("close0");
            method.setAccessible(true);
            Field fieldFd = fd.getClass().getDeclaredField("closed");
            fieldFd.setAccessible(true);
            Field path = fs.getClass().getDeclaredField("path");
            path.setAccessible(true);


            Field fieldIsr = in1.getClass().getDeclaredField("source");
            fieldIsr.setAccessible(true);

            for(int i=0;i<10;i++){
                System.out.println(in1.next());//clean buff
                if(i==2) {
                    method.invoke(fd,null);
                    //fieldFd.set(fd,true);
                    //path.set(fs,"empty");
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
