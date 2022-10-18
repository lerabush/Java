package third;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task9 {
    public static void main(String[] args) throws InterruptedException {
        Runnable[] tasks = generate(100);

        System.out.println("together");
        runTogether(tasks);
        System.out.println("in order");
        runInOrder(tasks);
    }
   static Runnable[] generate(int count) {
        List<Runnable> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int x = i+1;
            list.add(() -> {
                System.out.println(Math.pow(x,3));
            });
        }

        return list.toArray(new Runnable[]{});
    }
    static void runInOrder(Runnable... tasks) {
        for(Runnable task: tasks){
            task.run();
        }
    }
    static void runTogether(Runnable... tasks) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(tasks.length);
        for(Runnable task: tasks){
            executorService.execute(task);
        }
        executorService.shutdown();
        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
    }
}
