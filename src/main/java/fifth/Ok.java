package fifth;

public class Ok<V, E> implements Result<V, E> {
    private final V value;

    public Ok(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }
}