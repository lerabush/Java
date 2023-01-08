package sixth.thirteenth;

import com.beust.jcommander.internal.Lists;
import sixth.ninth.Employee;

import java.io.Closeable;
import java.util.*;
import java.util.function.Function;

//зашарить
public class Main {

    static List<Integer> list = new ArrayList<>();
    static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(list, 100, -10, 4, 205, 32);
        //minmax(list, Comparator.comparingInt(o -> o), resultList);
        System.out.println(resultList.toString());

       /* List<Integer> result2 = new ArrayList<>();
        maxMin(list, Comparator.comparingInt(o -> o), result2);
        System.out.println(result2);*/
    }

    public static <T extends Number, V extends Number & Closeable> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        result.add(getMin(elements, comp));
        result.add(getMax(elements, comp));
    }

    private static <T> T getMin(List<T> elements, Comparator<? super T> comp) {
        T min = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            if (comp.compare(min, elements.get(i)) > 0) {
                min = elements.get(i);
            }
        }
        return min;
    }

    private static <T> T getMax(List<T> elements, Comparator<? super T> comp) {
        T max = elements.get(0);
        for (int i = 1; i < elements.size(); i++) {
            if (comp.compare(max, elements.get(i)) < 0) {
                max = elements.get(i);
            }
        }
        return max;
    }

    public static <T> void swapHelper(List<T> result, int i, int j) {
        T obj = result.get(i);
        result.set(i, result.get(j));
        result.set(j, obj);
    }

    public static <T> void maxMin(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        //  minmax(elements, comp, result);
        //swapHelper(result, 0, 1);
    }


}