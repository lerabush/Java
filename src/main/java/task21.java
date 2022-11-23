import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class task21 {
    public static void main(String[] args) {
        List<String>[] result = construct(10);
        result[0] = new ArrayList<>();
        result[0].add("string");

        result[0].forEach(System.out::println);
    }

    @SafeVarargs
    public static <T> T[] construct(int size, T... template) {
        return java.util.Arrays.copyOf(template, size);
    }
}
