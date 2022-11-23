package sixth.thirteenth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    static List<Integer> list = new ArrayList<>();
    static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args){
        Collections.addAll(list, 100, -10, 4, 205, 32);
        minmax(list, Comparator.comparingInt(o -> o), resultList);
        System.out.println(resultList.toString());
    }

    public static <T> void maxMin(List<T> elements,Comparator<? super T> comp, List<? super T> result) {
        minmax(elements, comp, result);
        swapHelper(Main.resultList, 0, 1);
    }

    private static <T> void swapHelper(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    public static <T> void minmax(List<T> element, Comparator<? super T> comp, List<? super T> result) {
        if (element.size() > 0) {
            T min = element.get(0);
            T max = element.get(0);
            for (T elem : element) {
                if (comp.compare(elem, min) < 0) {
                    min = elem;
                }
                if ((comp.compare(elem, max) > 0)) {
                    max = elem;
                }
            }
            result.add(min);
            result.add(max);
        }
    }
}