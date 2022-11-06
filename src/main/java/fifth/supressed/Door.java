package fifth.supressed;

class SwingException extends Exception {
    public SwingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SwingException() {
    }
}
class CloseException extends Exception {}

class Door implements AutoCloseable {

    public void swing() throws Exception {
        System.out.println("The door is becoming unhinged!");
        throw new SwingException();
    }

    public void close() throws Exception {
        System.out.println("The door is now closed.");
        throw new CloseException();
    }
}