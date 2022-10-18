package third;

import java.util.stream.Stream;

public class Task5 {
    public static void main(String[] args) {
        print(IntSequence.constant(1));
    }
    private static void print(IntSequence sequence) {
        Stream.generate(sequence::next).limit(1000).forEach(System.out::print);
        System.out.println();
    }
}
