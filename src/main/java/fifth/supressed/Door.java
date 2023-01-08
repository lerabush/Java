package fifth.supressed;

import java.awt.*;

class SwingException extends Exception {
    public SwingException(String message, Exception cause) {
        super(message, cause);
    }

    public SwingException() {
    }
}

class CloseException extends Exception {
    public CloseException(String message) {
        super(message);
    }
}
class WindowException extends Exception {
    public WindowException(String message) {
        super(message);
    }
}

class DoorLock implements AutoCloseable {
    public void close() throws Exception {
        System.out.println("The lock is now closed.");
        throw new CloseException("Lock close exception");
    }
}
class DoorWindow  {
    public void watch() throws WindowException {
        throw new WindowException("Can't look through window");
    }
}


class Door implements AutoCloseable {

    DoorLock lock1 = new DoorLock();
    DoorWindow window = new DoorWindow();

    public void swing() throws SwingException {
        System.out.println("The door is becoming unhinged!");
        try{
            this.window.watch();
        }catch (Exception ex){
            throw new SwingException("oops",ex);
        }
    }

    public void close() throws CloseException {
        System.out.println("The door is now closed.");
        throw new CloseException("Door close exception");
    }
}