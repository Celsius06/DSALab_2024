import java.util.Arrays;
import java.util.Scanner;

public class Problem_1_iii {

    public static int minGap(int[] array, int numElements) {
        if (numElements < 2) {
            return 0;
        }

        Arrays.sort(array);

        int minGap = Integer.MAX_VALUE;
        for (int i = 1; i < numElements; i++) {
            int currentGap = array[i] - array[i - 1];
            minGap = Math.min(minGap, currentGap);
        }

        return minGap;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int numElements = sc.nextInt();
        int[] array = new int[numElements];

        System.out.print("Enter " + numElements + " elements separated by spaces: ");
        for (int i = 0; i < numElements; i++) {
            array[i] = sc.nextInt();
        }

        sc.close();

        System.out.print("Minimum gap between digits in the array: " + minGap(array, numElements));
    }
}
