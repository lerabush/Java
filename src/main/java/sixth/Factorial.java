package sixth;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {
    int number;

    // standard constructors

    public Integer call() throws Exception {
        int fact = 1;
        // ...
        for(int count = number; count > 1; count--) {
            fact = fact * count;
            if(fact==6) throw new Exception();
            System.out.println(fact);
        }

        return fact;
    }
}