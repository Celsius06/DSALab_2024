import java.util.Scanner;

public class Problem_6 {
    int gcd(int p, int q) {
        // Base case: if q = 0, return p
        if (q == 0) {
            return p;
        }
        // Recursive case: if q != 0, assign p = q and (p % q) = q
        return gcd(q, (p % q));
    }

    public static void main(String[] args) {
        Problem_6 p6 = new Problem_6();
        Scanner s = new Scanner(System.in);

        System.out.print("p = ");
        int p = s.nextInt();

        System.out.print("q = ");
        int q = s.nextInt();

        int gcdresult = p6.gcd(p, q);
        System.out.println("GCD = " + gcdresult);

        s.close();
    }
}
