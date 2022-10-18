package third;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyIterator<E> implements Iterator<E> {
    private Iterator<E> iterator;
   private List<E> elements;
    private E curr;

    public MyIterator() {
        this.elements = new ArrayList<>();
        this.iterator = null;
    }

    public MyIterator(Iterator<E> iterator) {
        this();
        this.iterator = iterator;
    }

    public MyIterator(List<E> elements) {
        this();
        this.elements = new ArrayList<>(elements);
        this.iterator = elements.iterator();
    }

    @Override
    public boolean hasNext() {
        if (iterator != null) {
            return !elements.isEmpty();
        }
        return false;
    }

    @Override
    public E next() {
        if (iterator != null) {
            if (!elements.isEmpty())
                return curr = elements.remove(0);
            return curr = this.iterator.next();
        }
        return null;
    }


    public static <E> MyIterator<E> fromIterator(Iterator<E> iterator){
        List<E> elements = new ArrayList<>();
        Iterator<E> tmp = iterator;
        while(tmp.hasNext()) elements.add(tmp.next());
        return new MyIterator<>(elements);
    }

    public void forEach(Consumer<E> consumerFunction) {
        MyIterator<E> tmp = new MyIterator<>(this.elements);
        while (tmp.hasNext()) {
            consumerFunction.accept(tmp.next());
        }
    }

    public void filter(Predicate<E> predicate) {
        List<E> filtered = new ArrayList<>();
        MyIterator<E> tmp = new MyIterator<>(this.elements);
        while (tmp.hasNext()) {
            E elem = tmp.next();
            if (predicate.test(elem)) filtered.add(elem);
        }
        this.elements = filtered;
    }

    public <U> MyIterator<U> map(Function<E, U> mapFunction) {
        List<U> mapElements = new ArrayList<>();
        while (this.hasNext()) {
            mapElements.add(mapFunction.apply(this.next()));
        }
        return new MyIterator<>(mapElements);
    }

    public <U> Map<U, E> collectToMap(Function<E, U> keyExtract) {
        Map<U, E> result = new HashMap<>();
        while (this.hasNext()) {
            E elem = this.next();
            result.put(keyExtract.apply(elem), elem);
        }
        return result;
    }

    public MyIterator<E> union(MyIterator<E> other) {
        List<E> newElements = new ArrayList<>();
        while (this.hasNext()) newElements.add(this.next());
        while (other.hasNext()) newElements.add(other.next());
        return new MyIterator<>(newElements);
    }


}
