import fourth.Cat;
import sixth.ninth.Animal;
import sixth.ninth.Dog;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class task21 {
    public static void main(String[] args) {
        List<String> first = new ArrayList<>();
        first.add("hello");
        first.add("hell");
        first.add("hel");
        first.add("he");
        List<String> second = new ArrayList<>();
        second.add("second");
        String[] result = construct(3, "hello", "java", "kotlin");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        /*
        Object[] result1 = construct(3, "hello", 1, false);
        for (int i = 0; i < result1.length; i++) {
            System.out.println(result1[i]);
        }
        List something = Arrays.stream(construct(3, true, "hello", 1)).toList();*/

        //possible heap pollution
        List animals = new ArrayList<Animal>();
        List cats = new ArrayList<Cat>();
        List[] resulthp = construct(1, animals, cats);
        resulthp[1].add(new Dog("Jim"));

    }

    @SafeVarargs //зачем и почему может возникнуть хип пол
    public static <T> T[] construct(int size, T... template) {
        return java.util.Arrays.copyOf(template, size);
    }
}
