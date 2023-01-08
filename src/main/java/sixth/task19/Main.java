package sixth.task19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = repeat(10, 10);

        Integer[] array = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(array));

        String[] tab = repeat1(5, "hi");
       // System.out.println(Arrays.stream(tab).toString());
    }

    public static <T> ArrayList<T> repeat(int n, T obj) {
        ArrayList<T> result = new ArrayList<>();
        for (int i = 0; i < n; i++)
            result.add(obj);
        return result;
    }

    public static <T> T[] repeat1(int n, T obj) {
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(obj);
        T[] tab = null;
        list.toArray(tab);
        return tab;
    }
    //    1) Object[] toArray(); использует в себе Class
    //    2) <T> T[] toArray(T[] a); тоже использует Class
    //    3) default <T> T[] toArray(IntFunction<T[]> generator) (Использует пред метод)

}
