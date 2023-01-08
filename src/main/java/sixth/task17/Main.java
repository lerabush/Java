package sixth.task17;

import java.lang.reflect.Method;

import static sixth.Task25.genericDeclaration;

public class Main {
    public static void main(String[] args) {
        Method[] methods = Employee.class.getMethods();
        for (Method method : methods) {
            System.out.println(genericDeclaration(method));
        }
    }
}
//Javap декомпилирует определения класса и показывает вам, что внутри.
/*Compiled from "Employee.java"
public class sixth.task17.Employee implements java.lang.Comparable<sixth.task17.Employee> {
public sixth.task17.Employee(java.lang.String, double);
public java.lang.String getName();
public double getSalary();
public int compareTo(sixth.task17.Employee);
public java.lang.String toString();
public int compareTo(java.lang.Object);
        }*/
