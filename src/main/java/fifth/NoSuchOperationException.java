package fifth;

public class NoSuchOperationException extends Exception {
    public NoSuchOperationException(String message) {
        super("Нет такой операции: " + message);
    }
}
