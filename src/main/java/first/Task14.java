package first;

import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Task14 {
   private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int length = enterInt("Enter size: ");
        int[][] square = new int[length][length];
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[0].length; j++) {
                square[i][j] = enterInt(String.format("[%s,%s]: ", i, j));
            }
        }
        System.out.println("-------------");
        printMatrix(square);
        System.out.println(isMagicSquare(square) ? "It`s a magic square" : "It`s ordinary square");
    }

    private static boolean isMagicSquare(int[][] square) {
        HashSet<Integer> set = new HashSet<>();
        //rows
        for (int[] ints : square) {
            set.add(IntStream.of(ints).sum());
        }
        //columns
        for (int i = 0; i < square.length; i++) {
            int s = 0;
            for (int j = 0; j < square[0].length; j++) {
                s += square[j][i];
            }
            set.add(s);
        }
        //diagonals
        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < square.length; i++) {
            d1 += square[i][i];
            d2 += square[i][square.length - 1 - i];
        }
        set.add(d1);
        set.add(d2);
        return set.size() <= 1;
    }

    private static int enterInt(String caption) {
        System.out.print(caption);
        return sc.nextInt();
    }

    private static void printMatrix(int[][] array) {
        for (int[] ints : array) {
            for (int y = 0; y < ints.length; y++) {
                int d = ints[y];
                System.out.print(String.format("%3d", d));
            }
            System.out.println();
        }
    }
}
