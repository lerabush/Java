package third;

import java.util.stream.Stream;

import static java.util.List.of;

public class Task1 {
    public static void main(String[] args) {
        Measurable[] employees = {
                new Employee(1000.0,"Ivanov",32),
                new Employee(3000.0,"Petrov",24),
                new Employee(2500.0,"Mironov",35)
        };
        System.out.println(average(employees));

    }
    public static double average(Measurable[] objects){
        return Stream.of(objects).mapToDouble(Measurable::getMeasure).average().orElse(0);
    }

}
//MyComparator c Generic