package third;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class IteratorExample {
    public static void main(String[] args){
        List<Employee> employeeList = List.of(new Employee(3000.0,"Ivanov",25),
                new Employee(2500.0,"Sidorov",34),
                new Employee(3400.0,"Arbuzov",27),
                new Employee(2200.0,"Vedov",28),
                new Employee(2000.0,"Danilov",31));

        MyIterator<Employee> iter1 = new MyIterator<>(employeeList);
        //увеличиваем зарплату
        iter1.forEach(x->x.setSalary(x.getSalary()*1.5));
        iter1.forEach(System.out::println);
        //фильтруем
        System.out.println("--------");
        iter1.filter(x->x.getAge()>=30);
        iter1.forEach(System.out::println);
        //объединяем
        System.out.println("--------");
        List<Employee> employeeListTwo = new java.util.ArrayList<>(List.of(new Employee(3000.0, "Ivanova", 25),
                new Employee(2200.0, "Sidorova", 35),
                new Employee(3000.0, "Arbuzova", 27),
                new Employee(1800.0, "Danilova", 28)));
        MyIterator<Employee> iter2 = new MyIterator<>(employeeListTwo);
        iter2 = iter1.union(iter2);
        iter2.forEach(System.out::println);
        //collectToMap
        Function<Employee,Integer> hashSurname = emp-> Math.abs(emp.getSurname().hashCode());
        Map<Integer,Employee> mapEmployees = iter2.collectToMap(hashSurname);
        for (Integer key : mapEmployees.keySet()) {
            System.out.println(key + ":" + mapEmployees.get(key));
        }
        //mapFunction
        System.out.println("----");
        Function<Employee,String> surname = emp -> emp.getSurname()+",age = "+emp.getAge();
        employeeListTwo.addAll(employeeList);
        MyIterator<Employee> iter3 = new MyIterator<>(employeeListTwo);
        MyIterator<String> stringIter = iter3.map(surname);
        stringIter.forEach(System.out::println);

    }
}
