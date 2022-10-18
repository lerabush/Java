package fourth;

import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

public class Task13 {
    public static void main(String[] args) throws Exception {
        DoubleFunction<Double> df = d -> d*d;
        try {
            print(Math.class.getMethod("sqrt", double.class), 5, 10, 1);
            print(Double.class.getMethod("toHexString", double.class), 1, 9, 1);
            print(df,1,10,1);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void print(Method m, double lower, double upper, double step) throws Exception {
        System.out.println(m.getDeclaringClass().getCanonicalName() + "." + m.getName());
        for (double i = lower; i <= upper; i += step) {
            System.out.printf("%.2f | %s\n", i, m.invoke(null, i));
        }
    }
    public static void print(DoubleFunction<Double> func, double lower, double upper, double step) throws Exception{
        for (double i = lower; i <= upper; i += step) {
            System.out.printf("%.2f | %s\n", i, func.apply(i));
        }
    }
}