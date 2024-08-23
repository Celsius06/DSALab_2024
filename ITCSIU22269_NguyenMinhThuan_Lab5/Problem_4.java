import java.util.Scanner;

public class Problem_4 {
    int findMin(int a[], int n) {
        // Base case: array has only a number
        if (n == 1) {
            return a[0];
        }
        // Recursive case: array has more than a number
        return Math.min(a[n - 1], findMin(a, n - 1));
    }

    int findSum(int a[], int n) {
        // Base case: array has only a number
        if (n == 1) {
            return a[0];
        }
        // Recursive case: add the first number to the sum the rest of the array forms
        return a[n - 1] + findSum(a, n - 1);
    }

    public static void main(String[] args) {
        Problem_4 p4 = new Problem_4();
        Scanner s = new Scanner(System.in);

        System.out.println("Array");

        System.out.print("Size = ");
        int size = s.nextInt();

        int[] a = new int[size];
        System.out.print("Elements: ");
        for (int i = 0; i < size; i++) {
            a[i] = s.nextInt();
        }

        System.out.print("");

        int min = p4.findMin(a, size);
        System.out.println("Minimum number = " + min);

        int sum = p4.findSum(a, size);
        System.out.println("Sum = " + sum);

        s.close();
    }
}
