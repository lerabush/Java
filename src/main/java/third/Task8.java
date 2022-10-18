package third;

public class Task8 {
    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new Greeter(5, "Lera"));
        Thread thread2 = new Thread(new Greeter(5, "World"));
        thread1.start();
        thread2.start();
    }
}
