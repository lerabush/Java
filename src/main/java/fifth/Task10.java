package fifth;
public class Task10 {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    private static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be greater 0");
        } else if (n <= 1) {
            return 1;
        }
        new Throwable().printStackTrace();
        return n * factorial(n - 1);
    }

}
