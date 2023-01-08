package sixth.fifth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Нужен cast потому что возвращается Object
       // Double[] result1 = (Double[])swap(0, 1, 1.5, 2, 3); //class cast exception

//        Нужно передавать только Double, так как мы его указали
        Double[] result2 = Main.<Double>swap(0, 1, 1.5, 2.0, 3.0);
        Double[] score = swap(0, 1, 1.5, 1.3, 1.8, 6d);
        System.out.println(Arrays.toString(score));
    }
    public static <T> T[] swap(int i, int j, T... value) {
        T temp = value[i];
        value[i] = value[j];
        value[j] = temp;
        return value;
    }
}
