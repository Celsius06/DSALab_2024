import java.util.Scanner;

public class Problem_2 {
    double sum(int n) { // n > 1
        if (n == 1) {
            return 1.0;
        }
        return 1.0 / n + sum(n - 1);
    }

    public static void main(String[] args) {
        Problem_2 p2 = new Problem_2();
        Scanner sc = new Scanner(System.in);

        System.out.print("n = ");
        int n = sc.nextInt();

        double sum = p2.sum(n);
        System.out.printf("For n = %d, sum = %.3f%n", n, sum);

        sc.close();
    }

}
