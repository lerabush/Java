package sixth;

import java.io.IOException;
import java.util.zip.InflaterOutputStream;

public class task23 {
    @SuppressWarnings("unchecked")
    private static <T extends Throwable>
    void throwAs(Throwable e) throws T {
        throw (T) e;
    }

    public static void main(String[] args) {
        task23.<RuntimeException>throwAs(new IOException("Hello world"));

    }

}
