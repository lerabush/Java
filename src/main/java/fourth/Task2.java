package fourth;

public class Task2 {
    public static void main(String[] args) {
        Point point = new Point(1.0, 2.0);
        System.out.println(point.toString());
        System.out.println(point.hashCode());
        System.out.println(point.equals(new Point(1, 2.5)));
        LabeledPoint label = new LabeledPoint("label 1", 1.0, 2.5);
        System.out.println(label.toString());
        System.out.println(label.hashCode());
        System.out.println(label.equals(new LabeledPoint("label 2", 1.0, 3.0)));
    }
}
