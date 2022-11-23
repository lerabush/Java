package sixth.first;

import java.util.ArrayList;
import java.util.List;

public class Stack<E> {
    private List<E> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public E push(E item) {
        list.add(item);
        return list.get(list.size() - 1);
    }
}
