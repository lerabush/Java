package fifth;

public interface Result<V, E> {
    static <V, E> Ok ok(final V value) {
        return new Ok(value);
    }

    static <V, E> Error err(final E error) {
        return new Error(error);
    }
}