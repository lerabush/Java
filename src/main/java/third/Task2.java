package third;

import java.util.Comparator;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee(1000.0,"Ivanov",30),
                new Employee(3000.0,"Petrov",31),
                new Employee(3000.0,"Mironov",32),
                new Employee(1000.0, "Sidorov",33)
        };
        Employee emp = (Employee) largest(employees);
        System.out.println("Worker with the largest salary: "+ emp.getSurname()+", salary: "+emp.getMeasure());
    }
    public static Measurable largest (Measurable[] objects){
        return Stream.of(objects).max(Comparator.comparing(Measurable::getMeasure)).orElse(null);
    }
}
/*Task 3: String: java.io.Serializable, Comparable<String>, CharSequence
Scanner: Closeable, AutoCloseable, Iterator<String>
IOS:Closeable, AutoCloseable, DataI/O, IIS
*/