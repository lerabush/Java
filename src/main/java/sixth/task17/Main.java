package sixth.task17;

import java.lang.reflect.Method;

import static sixth.Task25.genericDeclaration;

public class Main {
    public static void main(String[] args) {
        Method[] methods = Employee.class.getMethods();
        for (Method method : methods) {
            System.out.println(genericDeclaration(method));
        }
    }
}
//Javap декомпилирует определения класса и показывает вам, что внутри.