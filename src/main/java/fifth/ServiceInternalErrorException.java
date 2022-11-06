package fifth;

public class ServiceInternalErrorException extends Exception{
    public ServiceInternalErrorException(String message) {
        super(message);
    }
    public ServiceInternalErrorException(String message,Exception ex) {
        super(message,ex);
    }
}
