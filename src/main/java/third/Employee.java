package third;

import org.testng.annotations.ObjectFactory;

public class Employee implements Measurable {

    private String surname;
    private Double salary;
    private  int age;

    public Employee(Double salary, String surname, int age) {
        this.salary = salary;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public double getMeasure() {
        return salary;
    }
    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return this.getSurname()+", "+this.getAge()+", "+this.getSalary();
    }

}