package first;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task13 {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1,49).boxed().collect(Collectors.toList());
        int[] res = new int[6];
        for (int i = 0; i < 6; i++) {
            int idx = getRandom(0,numbers.size()-1);
            res[i] = numbers.remove(idx);
        }
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
    }
    private static int getRandom(int a, int b) {
        return (int) (Math.random() * (b - a + 1)) + a;
    }
}
