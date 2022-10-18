package fourth;

public class Task1 {
    public static void main(String[] args) {
        Point p1 = new Point(1.0, 2.5);
        Point p2 = new Point(1.0, 2.5);
        Point p3 = null;
        Point p4 = p2;
        Point p5 = new Point(1.0,3.0);


        LabeledPoint lp1 = new LabeledPoint("label1",1.0,3.0);
        LabeledPoint lp2 = new LabeledPoint("label1",1.0,3.0);
        LabeledPoint lp3 = new LabeledPoint("label2",1.0,3.0);
        LabeledPoint lp4 =  new LabeledPoint("label2",1.5,3.0);
        LabeledPoint lp5 = null;
        LabeledPoint lp6 = lp2;

        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p5));
        System.out.println(p1.equals(p4));
        System.out.println(p1.equals(p3));

        System.out.println(lp1.equals(lp2));
        System.out.println(lp1.equals(lp3));
        System.out.println(lp1.equals(lp4));
        System.out.println(lp1.equals(lp5));
        System.out.println(lp1.equals(lp6));

    }
}