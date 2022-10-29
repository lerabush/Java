package fifth;

public class Result<V> {
    private final int errorCode;


    private final V result;

    public int getErrorCode() {
        return errorCode;
    }


    public V getResult() {
        return result;
    }

    public Result(int errorCode, V result) {
        this.errorCode = errorCode;
        this.result = result;
    }
}