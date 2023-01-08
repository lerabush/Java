package fifth.supressed;

import fourth.Run;

public class SupressedExceptionExample {
    public static void main(String[] args) throws Throwable {
        suppressedExample1();
        // chainedExample();
    }

    public static void suppressedExample() throws SwingException, CloseException {
        Door door = new Door();
        SwingException mainEx;
        try {
            mayThrowError();
            door.swing();
            door.close();
        } catch (SwingException ex1) {
            mainEx = ex1;
            try {
                door.close();
            } catch (CloseException ex2) {
                mainEx.addSuppressed(ex2);
                throw mainEx;
            }
        }
    }

    public static void suppressedExample1() throws SwingException, CloseException {
        Exception mainEx = null;
        Error error = null;
        Door door = new Door();
        try {
            if(1>0) throw new NullPointerException();
            mayThrowError();
            door.swing();
        } catch (Error err) {
            error = err;
        } catch (Exception ex) {
            mainEx = ex;
        }
        finally {
            if (error != null) throw error;
            try {
                door.close();
            } catch (CloseException ex) {
                if (mainEx == null) {
                    mainEx = ex;
                } else {
                    mainEx.addSuppressed(ex);
                }
            }
        }
        if (mainEx != null) {
            if(mainEx instanceof SwingException) throw (SwingException) mainEx;
            if(mainEx instanceof RuntimeException) throw (RuntimeException) mainEx;
            if (mainEx instanceof CloseException) throw (CloseException) mainEx;
        }
    }

    /*public static void suppressedExample() throws Throwable {
        Door door = new Door();
        Throwable mainEx = null;
        try {
            throw new OutOfMemoryError();
            //door.swing();
        } catch (Exception | Error ex1) {
            mainEx = ex1;
            if(mainEx instanceof Error) throw mainEx;
        } finally {
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
    }*/
    public static void mayThrowError() {
        throw new OutOfMemoryError();
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