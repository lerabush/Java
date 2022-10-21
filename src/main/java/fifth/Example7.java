package fifth;

public class Example7 implements AutoCloseable {

    public static void main(String[] args) {
        try (Example7 ex1 = new Example7();
             Example7 ex2 = new Example7()) {
            throw new RuntimeException("Main exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for (Throwable t : e.getSuppressed()) {
                System.out.println(t.getMessage());
            }
        }
    }

    @Override
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Suppressed Exception");
    }
}
