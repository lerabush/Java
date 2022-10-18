package third;

public class Task4 {
    public static void main(String[] args) {
        IntSequence sequence = IntSequence.of(3, 1, 4, 1, 5, 9);
        while (sequence.hasNext()){
            System.out.println(sequence.next());
        }
    }
}
