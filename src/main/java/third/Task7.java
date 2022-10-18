package third;

import java.util.*;

public class Task7 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>(List.of("aaa", "bbbb", "ccccc","fffffffffff"));
        System.out.println(strings);
        luckySort(strings,Comparator.comparing(String::length));
        System.out.println(strings);
    }
    static void luckySort(ArrayList<String> strings, Comparator<String> comp){
        while(true){
            Collections.shuffle(strings);
            for(int i = 0;i<strings.size();i++){
                if (comp.compare(strings.get(i + 1), strings.get(i)) < 0) {
                    return;
                }
            }
        }
    }

}
