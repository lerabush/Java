package sixth.fifth;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Double[] score = swap(0, 1, 1.5, 2, 3);
        //Double[] score = Arrays.<Double>swap(0, 1, 1.5, 2, 3);

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
