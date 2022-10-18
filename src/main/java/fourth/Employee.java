package fourth;

public abstract class Employee {

    @Run
    public void run(){
        runAsHeCan();
    }
    @Run
    public static void staticRun(){
        System.out.println("static");
    }

    @Run
    public abstract void go();

    protected abstract void runAsHeCan();
}
