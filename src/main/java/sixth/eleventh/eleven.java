package sixth.eleventh;

import sixth.ninth.Pair;

import java.util.ArrayList;
import java.util.Collections;

public class eleven {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 2, 4, 5, 6);
        Pair<Integer> minMax = Arrays.minMax(list);
        System.out.println("First = " + minMax.getFirst() + " Second = " + minMax.getSecond());

    }
}
