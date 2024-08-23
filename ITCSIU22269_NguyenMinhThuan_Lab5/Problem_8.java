import java.util.Scanner;

public class Problem_8 {
    static class Subset {
        private static void subsetGenerator(String s, int index, String subset) {
            if (index == s.length()) {
                System.out.println(subset);
                return;
            }
            // Include current character
            subsetGenerator(s, index + 1, subset + s.charAt(index));
            // Exclude current character
            subsetGenerator(s, index + 1, subset);
        }

        private static void runSubsetGenerator(String s) {
            subsetGenerator(s, 0, "");
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter the string: ");
            String str = sc.nextLine();
            System.out.println("The subsets: ");
            runSubsetGenerator(str);

            sc.close();
        }
    }
}
