package fifth.supressed;

public class SupressedExceptionExample {
    public static void main(String[] args) throws Throwable {
       suppressedExample();
        // chainedExample();
    }

    public static void suppressedExample() throws SwingException, CloseException {
        Door door = new Door();
        Throwable mainEx = null;
        try {
            throw new OutOfMemoryError();
            //door.swing();
        } catch (Exception | Error ex1) {
            mainEx = ex1;

        } finally {
            if(mainEx instanceof Error) throw mainEx;
            try {
                door.close();
            } catch (Exception ex2) {
                if (mainEx == null) {
                    throw ex2;
                } else {
                    mainEx.addSuppressed(ex2);
                }
                System.out.println(mainEx.getSuppressed()[0]);
                throw mainEx;
            }
        }
    }

    public static void chainedExample() {
        Door door = new Door();
        Exception mainEx = null;
        try {
            door.swing();
        } catch (Exception ex) {
            mainEx = ex;
        } finally {
            try {
                door.close();
            } catch (Exception exception) {
                if (mainEx != null) {
                    mainEx.initCause(exception);
                    mainEx.printStackTrace();

                } else exception.printStackTrace();
            }
        }
    }

}