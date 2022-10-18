package fourth;

public class ExceptionThrow {
    @Run
    public static int nullDivider() {
        return 5 / 0;
    }
    @Run
    public void nullPointerThrow(){
        throw new NullPointerException("Null was returned");
    }
}
