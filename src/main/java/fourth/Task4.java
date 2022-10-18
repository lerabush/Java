package fourth;

public class Task4 {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point(2, 5), 10);
        System.out.println(circle.getCenter());
        circle.moveBy(6, 0);
        System.out.println(circle.getCenter());

        Line line = new Line(new Point(1, 1), new Point(3, 6));
        Rectangle rectangle = new Rectangle(new Point(5, 10), 20, 10);
        System.out.println(rectangle);
        System.out.println(circle);
        System.out.println(line);
    }

    protected static class Circle extends Shape implements Cloneable {
        private double radius;

        public Circle(Point point, double radius) {
            super(point);
            this.radius = radius;
        }

        @Override
        public Point getCenter() {
            return this.point;
        }

        @Override
        protected Circle clone() {
            try {
                Circle cloned = (Circle) super.clone();
                cloned.point = new Point(point.getX(), point.getY());
                return cloned;
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
        @Override
        public String toString() {
            return "Circle{" +
                    "radius=" + radius +
                    ", centre=" + point +
                    '}';
        }

    }

    protected static class Rectangle extends Shape implements Cloneable {
        private double width;
        private double height;

        public Rectangle(Point topLeft, double width, double height) {
            super(topLeft);
            this.width = width;
            this.height = height;
        }

        @Override
        public Point getCenter() {
            return new Point((point.getX() + width) / 2, (point.getY() + height) / 2);
        }

        @Override
        protected Rectangle clone() {
            try {
                Rectangle cloned = (Rectangle) super.clone();
                cloned.point = new Point(point.getX(), point.getY());
                return cloned;
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "width=" + width +
                    ", height=" + height +
                    ", point=" + point +
                    '}';
        }
    }

    protected static class Line extends Shape implements Cloneable {
        private Point from;
        private Point to;

        public Line(Point from, Point to) {
            super(null);
            this.from = from;
            this.to = to;
            this.point = new Point(
                    (from.getX() + to.getX()) / 2,
                    (from.getY() + to.getY()) / 2
            );
        }

        @Override
        public Point getCenter() {
            return point;
        }


        @Override
        protected Line clone() {
            try {
                Line cloned = (Line) super.clone();
                cloned.point = new Point(point.getX(), point.getY());
                cloned.from = new Point(from.getX(), from.getY());
                cloned.to = new Point(to.getX(), to.getY());
                return cloned;
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }

        @Override
        public String toString() {
            return "Line{" +
                    "pointFrom=" + from +
                    ", pointTo=" + to +
                    '}';
        }

    }
}