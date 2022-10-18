package third;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

public class TestComparator {

   public static void main(String[] args){
       List<Employee> sortedEmpList = new ArrayList<>();
       List<Employee> employeeList = List.of(new Employee(3000.0,"Ivanov",25),
               new Employee(2500.0,"Sidorov",34),
               new Employee(3400.0,"Arbuzov",27),
               new Employee(2500.0,"Vedov",28));

       ComparatorCreator creator = EmployeeComparator::new;//ссылка на конструктор
       MyComparator comp = creator.create();

        sortedEmpList = EmployeeComparator.sortEmployeeList(comp,employeeList);
        print(sortedEmpList);
        sortedEmpList.clear();


        MyComparator comp2 = MyComparator.comparing(String::valueOf,comp);//ссылка статик
       sortedEmpList = EmployeeComparator.sortEmployeeList(comp2,employeeList);
       print(sortedEmpList);
       sortedEmpList.clear();

       MyComparator comp3 = MyComparator.comparing(x->x.substring(2)).thenComparing(comp2);
       sortedEmpList = EmployeeComparator.sortEmployeeList(comp3,employeeList);
       print(sortedEmpList);
       sortedEmpList.clear();

    }
    public static void print(List<Employee> list) {
        for (Employee emp : list) {
            System.out.println(emp.toString());
        }
        System.out.println();
    }




}
