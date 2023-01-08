package sixth.ninth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {
    String name = "";
    String department = "";
    int age = 0;

    public Employee(String name) {
        this.name = name;
    }
    public Employee(){}
    public Employee(String name,String department,int age){
        this(name);
        this.department = department;
        this.age = age;
    }
    /*public Employee(Object... args) {
        List<Object> props = new ArrayList<>(Arrays.stream(args).toList());
        while(!props.isEmpty()){
            this.name = props.get(0).toString();
            props.remove(0);
            if(props.isEmpty()) break;
            this.department = props.get(0).toString();
            props.remove(0);
            if(props.isEmpty()) break;
            this.age = (Integer) props.get(0);
            props.remove(0);
            if(props.isEmpty()) break;
        }

    }*/
}
