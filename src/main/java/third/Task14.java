package third;

import java.util.Arrays;
import java.util.Comparator;

public class Task14 {
    public static void main(String[] args){
        Employee[] employees = {
                new Employee(1000.0,"Ivanov",30),
                new Employee(3000.0,"Petrov",31),
                new Employee(3000.0,"Mironov",32),
                new Employee(1000.0, "Sidorov",33)
        };
        sortBySalaryThenBySurname(employees);
        for(Employee emp: employees) System.out.println(emp.getSurname()+", "+emp.getMeasure());

    }
    private static void sortBySalaryThenBySurname(Employee[] employees) {
        Arrays.sort(employees, Comparator.comparing(Employee::getMeasure).thenComparing(Employee::getSurname));
    }

}
