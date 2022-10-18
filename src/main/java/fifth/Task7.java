package fifth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task7 {
    //Следует отметить, что при использовании AutoCloseable ,
    // это исключение, вызванное в методе close , которое подавляется . Возникает исходное исключение.
    public static void main(String[] args) throws Exception {
        //проверка на ввод
        Scanner in = new Scanner(System.in);
        try {
            in.nextShort(2);
        } catch (InputMismatchException ex) {
            System.out.println("ex");
        }
        System.out.println("Hello!");

        in.close();
        //подавленные
       // demoAddSuppressedException("notfound");
        demoChainException("notfound");
        //try c ресурсами
        try (Scanner in1 = new Scanner(new File("src/main/resources/notfound.txt"))) {
            while (in1.hasNext()) {
                System.out.println(in1.next());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void demoAddSuppressedException(String filePath) throws Exception {
        Exception firstException = null;
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(filePath);
        } catch (IOException e) {
            firstException = e;
        } finally {
            try {
                fileIn.close();
            } catch (NullPointerException npe) {
                if (firstException != null) {
                    firstException.addSuppressed(npe);
                    System.out.println(Arrays.toString(firstException.getSuppressed()));
                    System.out.println(Arrays.toString(npe.getSuppressed()));
                }
                throw firstException;
            }
        }
    }
    public static void demoChainException(String filePath) throws Exception {
        Exception firstException = null;
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream(filePath);
        } catch (IOException e) {
            firstException = e;
        } finally {
            try {
                fileIn.close();
            } catch (NullPointerException npe) {
              //  throw new NullPointerException("because file doesn't exist;",firstException); - не компилируется
                assert firstException != null;
                npe.initCause(firstException);
                throw npe;
            }
        }
    }

    /*
    private void readInput() {
        if (buf.limit() == buf.capacity())
            makeSpace();
        // Prepare to receive data
        int p = buf.position();
        buf.position(buf.limit());
        buf.limit(buf.capacity());

        int n = 0;
        try {
            n = source.read(buf);
        } catch (IOException ioe) {
            lastException = ioe;
            n = -1;
        }
        if (n == -1) {
            sourceClosed = true;
            needInput = false;
        }
        if (n > 0)
            needInput = false;
        // Restore current position and limit for reading
        buf.limit(buf.position());
        buf.position(p);
    }
     */
    /*
    public void close() {
        if (closed)
            return;
        if (source instanceof Closeable) {
            try {
                ((Closeable)source).close();
            } catch (IOException ioe) {
                lastException = ioe;
            }
        }
        sourceClosed = true;
        source = null;
        closed = true;
    }
     */

}
