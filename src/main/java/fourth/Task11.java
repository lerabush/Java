package fourth;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Task11 {
    static Method methodToCall = null;

    static A aObject = null;

    public static void main(String[] args) {
        reflexionCall();
    }
    public static class A {
        public int value = 0;

        public void add(int x) {
            value += x;
        }
    }

    public static void reflexionCall() {
        try {
            A a = new A();
            Method method = A.class.getDeclaredMethod("add", int.class);
            method.setAccessible(true);
            method.invoke(a,1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void reflexionCall1() {
        try {
            if (methodToCall == null) {
                aObject = new A();
                methodToCall = A.class.getDeclaredMethod("add", int.class);
                methodToCall.setAccessible(true);
            }
            methodToCall.invoke(aObject,1);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
