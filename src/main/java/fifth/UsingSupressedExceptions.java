package fifth;

public class UsingSupressedExceptions {
    public static void main(String[] args) {

        try {
            method1();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void method1() throws Exception {
        Throwable first = null;
        try {
            method3();
        } catch (Exception exception) {
            first = exception;
            try {
                throw new Exception("Exception thrown in method1");
            } catch (Exception ex) {
                ex.addSuppressed(first);
                throw ex;
            }
        }
    }

    public static void method2() throws Exception {
        Throwable first = null;
        try {
            method3();
        } catch (Exception exception) {
            first = exception;
            try {
                throw new Exception("Exception thrown in method2");
            } catch (Exception ex) {
                ex.addSuppressed(first);
                throw ex;
            }
        }
    }

    public static void method3() throws Exception {
        throw new Exception("Exception thrown in method3");
    }
}
