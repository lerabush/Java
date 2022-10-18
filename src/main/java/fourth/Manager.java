package fourth;

public class Manager extends Employee{

    @Override
    public void runAsHeCan() {
        System.out.println("Run as manager");
    }

    @Override
    public void go(){
        System.out.println("go manager");
    }

}
