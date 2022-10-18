package fifth;

import java.util.Arrays;
import java.util.Random;


public class Task12 {
    private static final int MAX_NUMBER = 10000;

    public static void main(String[] args) {
        int[] array = generateRandomArray(1000000);
        long start = System.currentTimeMillis();
        System.out.println(min(array));
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }

    private static int[] generateRandomArray(int length) {
        Random random = new Random();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = random.nextInt(MAX_NUMBER);
        }
        return arr;
    }

    private static int min(int[] values) {
        if (values.length < 1) {
            throw new IllegalArgumentException("array is empty!");
        }
        int min = Arrays.stream(values).min().getAsInt();
        assert Arrays.stream(values).allMatch(value -> value >= min);
        return min;
    }
}
