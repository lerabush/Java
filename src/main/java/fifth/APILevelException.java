package fifth;

public class APILevelException extends Exception {
    public APILevelException(String message,Exception ex) {
        super(message,ex);
    }
    public APILevelException(String message) {
        super(message);
    }
}
