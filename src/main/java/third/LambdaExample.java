package third;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class LambdaExample {
    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("Elena");
        nameList.add("John");
        nameList.add("Alex");
        nameList.add("Jim");
        nameList.add("Sara");
        Random random = new Random();
        RandomClassNamer randomNamerObject = new RandomClassNamer() {
            List<String> names = nameList;
            @Override
            public String getRandomName() {
                int value = random.nextInt(names.size()-1);
                return names.get(value);
            }
            @Override
            public void printList(){
                for(String i: names){
                    System.out.println(i);
                }
            }
            @Override
            public void printRandomName(){
                System.out.println(getRandomName());
            }
        };

        RandomNamer randomNamerLambda = () -> {
            int value = (int) (Math.random() * nameList.size());
            return nameList.get(value);
        };

        randomNamerObject.printRandomName();
        System.out.println(randomNamerLambda.getRandomName());

    }
}
