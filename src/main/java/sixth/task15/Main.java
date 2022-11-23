package sixth.task15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T elem : list) {
            result.add(function.apply(elem));
        }
        return result;
    }
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(10,11,12,13,14,15,16,17,18,19,20);
        List<String> strings = map(numbers, o -> o + "^2 = " + o * o);
        System.out.println(strings);
    }

}
