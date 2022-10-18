package second;

import java.util.List;
import java.util.Random;

public class RandomElement {
    private static final Random generator = new Random();

    public static int nextInt(int low, int high) {
        return low + generator.nextInt(high - low + 1);
    }

    public static int nextInt() {
        return nextInt(0, Integer.MAX_VALUE - 1);
    }

    public static int randomElement(int[] elems) {
        return elems.length == 0 ? 0 : elems[nextInt(0, elems.length - 1)];
    }

    public static int randomElement(List<Integer> elems) {
        return elems.size() == 0 ? 0 : elems.get(nextInt(0, elems.size() - 1));
    }


}
