package sixth.ninth;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 2, 4, 5, 6);
        Pair<Integer> firstLast = Arrays.firstLast(list);
        System.out.println("First = " + firstLast.getFirst() + " Second = " + firstLast.getSecond());

        ArrayList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 100, -2, 40, 52, 76);
        Pair<Integer> minMax = Arrays.minMax(list1);
        System.out.println("min = " + minMax.getFirst() + ", max = " + minMax.getSecond());
    }
}
