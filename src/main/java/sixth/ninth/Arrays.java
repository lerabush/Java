package sixth.ninth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Arrays {
    public static <E> Pair<E> firstLast(ArrayList<? extends E> a){
        return new Pair<>(a.get(0),a.get(a.size()-1));
    }
    public static <E> Pair<E> firstLast1(ArrayList<E> a){
        return new Pair<>(a.get(0),a.get(a.size()-1));
    }
    public static <E extends Comparable> E min(ArrayList<E> list){
        return (E) list.get(list.indexOf (Collections.min(list)));
    }

    public static <E extends Comparable> E max(ArrayList<E> list){
        return (E) list.get(list.indexOf (Collections.max(list)));
    }

    public static <E extends Comparable> Pair<E> minMax(ArrayList<E> list){
        return new Pair<E>(min(list),max(list));
    }

}
