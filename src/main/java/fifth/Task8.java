package fifth;

import static fifth.Lock.lock;

public class Task8 {
    public static void main(String[] args) {
        printByCountWithLock("Hello world", 100);
    }

    private static void printByCountWithLock(String message, int count) {
        Thread thread1 = new Thread(() -> printToCountWithLock(message + 1, count));
        Thread thread2 = new Thread(() -> printToCountWithLock(message + 2, count));
        thread1.start();
        thread2.start();
    }

    private static void printByCount(String message, int count) {
        Thread thread1 = new Thread(() -> printToCount(message + 1, count));
        Thread thread2 = new Thread(() -> printToCount(message + 2, count));
        thread1.start();
        thread2.start();
    }


    public static void printToCountWithLock(String message, int count) {
        try (AutoCloseable autoCloseable = lock()) {
            for (int i = 0; i < count; i++) {
                System.out.println(message);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void printToCount(String message, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }
}
