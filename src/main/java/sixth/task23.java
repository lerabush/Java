package sixth;

import java.io.IOException;
import java.util.zip.InflaterOutputStream;

public class task23 {
    @SuppressWarnings("unchecked")
    private static <T extends Throwable>
    void throwAs(Throwable e) throws T {
        throw (T) e;
    }
    private static void throwAs1(Throwable ex) throws RuntimeException {
        throw (RuntimeException) ex;
    }

    public static void main(String[] args) {
        task23.<RuntimeException>throwAs(new IOException("Hello world"));
        //task23.throwAs1(new IOException("oh no")); потому что мы можем получить ClassCastException
    }

}
