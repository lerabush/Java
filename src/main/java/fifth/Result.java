package fifth;

public class Result<V> {
    private final int errorCode;

    private final String errorMessage;

    private final V result;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public V getResult() {
        return result;
    }

    public Result(int errorCode, String errorMessage, V result) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.result = result;
    }
}