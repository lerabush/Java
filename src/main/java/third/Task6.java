package third;

import java.util.Iterator;
import java.util.stream.Stream;

public class Task6 {
    public static void main(String[] args) {
        Iterator<Integer> sequence = new DigitSequence();
        print(sequence, 10);
        sequence.remove();
    }
    private static void print(Iterator<Integer> sequence, int limit) {
        Stream.generate(sequence::next).limit(limit).forEach(System.out::print);
        System.out.println();
    }

    static class DigitSequence implements Iterator<Integer> {

        private int value = 0;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return value++;
        }

        public void remove() {
        }
    }
}
