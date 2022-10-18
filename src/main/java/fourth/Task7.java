package fourth;

public class Task7 {
    public static void main(String[] args) {
        System.out.println(Colors.getBlue());
        System.out.println();
        for (Colors color : Colors.values()) {
            System.out.println(color);
        }
    }

    enum Colors {
        BLACK, RED, BLUE, GREEN, CYAN, MAGENTA, YELLOW, WHITE;

        static Colors getRed() {
            return RED;
        }

        static Colors getGreen() {
            return GREEN;
        }

        static Colors getBlue() {
            return BLUE;
        }
    }
}