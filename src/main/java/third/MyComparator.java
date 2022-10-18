package third;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
@FunctionalInterface
public interface MyComparator extends Comparator<String> {

    int compare(String o1, String o2);

    boolean equals(Object obj);

    static MyComparator comparing(Function<? super String, String> keyExtractor) {

        return (o1, o2) -> keyExtractor.apply(o1).compareTo(keyExtractor.apply(o2));
    }

    static MyComparator comparing(Function<? super String, String> keyExtractor, MyComparator other) {
        return (o1, o2) -> other.compare(keyExtractor.apply(o1), keyExtractor.apply(o2));
    }

    static MyComparator comparingInt(ToIntFunction<String> keyExtractor) {
        return (o1, o2) -> Integer.compare(keyExtractor.applyAsInt(o1), keyExtractor.applyAsInt(o2));
    }

    static MyComparator comparingDouble(ToDoubleFunction<String> keyExtractor) {
        return (o1, o2) -> Double.compare(keyExtractor.applyAsDouble(o1), keyExtractor.applyAsDouble(o2));
    }

    static MyComparator comparingLong(ToLongFunction<String> keyExtractor) {
        return (o1, o2) -> Long.compare(keyExtractor.applyAsLong(o1), keyExtractor.applyAsLong(o2));
    }

    static MyComparator naturalOrder() {
        return String::compareTo;
    }

    default MyComparator reversed() {
        return (o1, o2) -> this.compare(o2, o1);
    }

    default MyComparator thenComparing(MyComparator other) {
        return (o1, o2) -> {
            if (this.compare(o1, o2) != 0) return this.compare(o1, o2);
            else return other.compare(o1, o2);
        };
    }

    default MyComparator thenComparing(Function<? super String, String> keyExtractor, MyComparator other) {
        return (o1, o2) -> {
            if (this.compare(keyExtractor.apply(o1), keyExtractor.apply(o2)) != 0) return this.compare(keyExtractor.apply(o1), keyExtractor.apply(o2));
            else return other.compare(keyExtractor.apply(o1), keyExtractor.apply(o2));
        };
    }

    default <U extends Comparable<? super U>> MyComparator thenComparing(Function<? super String, ? extends U> keyExtractor) {
        return (o1, o2) -> {
            if (this.compare(o1, o2) != 0) return this.compare(o1, o2);
            else return keyExtractor.apply(o1).compareTo(keyExtractor.apply(o2));
        };
    }

    default MyComparator thenComparingInt(ToIntFunction<? super String> keyExtractor) {
        return (o1, o2) -> {

            if (this.compare(o1, o2) != 0) return this.compare(o1, o2);
            else return Integer.compare(keyExtractor.applyAsInt(o1), keyExtractor.applyAsInt(o2));
        };
    }

    default MyComparator thenComparingLong(ToLongFunction<? super String> keyExtractor) {
        return (o1, o2) -> {
            if (this.compare(o1, o2) != 0) return this.compare(o1, o2);
            else return Long.compare(keyExtractor.applyAsLong(o1), keyExtractor.applyAsLong(o2));
        };
    }

    default MyComparator thenComparingDouble(ToDoubleFunction<? super String> keyExtractor) {
        return (o1, o2) -> {
            if (this.compare(o1, o2) != 0) return this.compare(o1, o2);
            else return Double.compare(keyExtractor.applyAsDouble(o1), (keyExtractor.applyAsDouble(o2)));
        };
    }


}
