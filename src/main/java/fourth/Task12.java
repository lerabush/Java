package fourth;


public class Task12 {
    public static void main(String[] args) {
        long startTime1 = System.nanoTime();
        Task11.A a = new Task11.A();
        for (long i = 0; i < 1000000; i++) {
            a.add(1);
        }
        long time1 = System.nanoTime() - startTime1;
        long startTime2 = System.nanoTime();
        for (long i = 0; i < 1000000; i++) {
            Task11.reflexionCall();
        }
        long time2 = System.nanoTime() - startTime2;

        long startTime3 = System.nanoTime();
        for (long i = 0; i < 1000000; i++) {
            Task11.reflexionCall1();
        }
        long time3 = System.nanoTime() - startTime3;
        System.out.println("time1: " + time1 + ", time2: " + time2 + ", time3: " + time3);
        System.out.println("compare time1 to time2: " + (double) time2 / time1);
        System.out.println("compare time1 to time3: " + (double) time3 / time1);
    }

}
