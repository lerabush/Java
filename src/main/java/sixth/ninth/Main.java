package sixth.ninth;


import fourth.Task11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static sixth.ninth.Arrays.firstLast;
import static sixth.ninth.Arrays.firstLast1;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 10, 2, 4, 5, 6);
        Pair<Integer> firstLast = firstLast(list);
        System.out.println("First = " + firstLast.getFirst() + " Second = " + firstLast.getSecond());

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Tom"));
        cats.add(new Cat("Jerry"));
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("elephant"));
        animals.add(new Animal("cat"));
        //? extends E
        Pair<Animal> animalsPair = firstLast(cats);
        animalsPair = firstLast(animals);
        //просто E
        //animalsPair = firstLast1(cats); //нельзя! ковариантность потеряли
        //только так
        animalsPair = firstLast1(animals);
        ArrayList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 100, -2, 40, 52, 76);
        Pair<Integer> minMax = Arrays.minMax(list1);
        System.out.println("min = " + minMax.getFirst() + ", max = " + minMax.getSecond());


    }
}
