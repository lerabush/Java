package second;

public class Task6 {
    static class Point {
        private double x;
        private double y;

        public Point() {
            this.x = 0;
            this.y = 0;
        }

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
        /**
         * Перемещает точку на заданные расстояния по х и у
         * @param moveX перемещение по оси х
         * @param moveY перемещение по оси у
         * @return эту же точку с новыми координатами
         */

        public Point translate(double moveX, double moveY) {
            this.x += moveX;
            this.y += moveY;
            return this;
        }

        /**
         * Масштабирует координаты точки по обеим осям
         * @param k коэффициент масштабирования
         * @return эту же точку с новыми координатами
         */
        public Point scale(double k) {
            this.x *= k;
            this.y *= k;
            return this;
        }

    }

    public static void main(String[] args) {
        Point p = new Point(3,4).translate(1,3).scale(0.5);
        System.out.printf("X: %s, Y: %s ",p.getX(),p.getY());
    }
    // Да, имеются. Генерация конструкторов, геттеров и сеттеров, например
}
