package fifth;

public class Error<V, E> implements Result<V, E> {
    private final E error;

    public Error(E error) {
        this.error = error;
    }

    public E getError() {
        return error;
    }
}