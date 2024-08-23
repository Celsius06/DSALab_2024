import java.util.Scanner;
import java.util.Stack;

public class Problem_1_UserInput {
    // Convert a decimal number to octal form
    public static String decimalToOctal(int decimal) {
        return Integer.toOctalString(decimal);
    }

    // Concatenate two stacks
    public static <T> Stack<T> concatenate(Stack<T> s1, Stack<T> s2) {
        Stack<T> newStack = new Stack<>();
        newStack.addAll(s1);
        newStack.addAll(s2);
        return newStack;
    }

    // Determine if the contents of one stack are identical to that of another
    public static <T> boolean stackIdentifier(Stack<T> s1, Stack<T> s2) {
        return s1.equals(s2);
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Decimal to octal conversion
        System.out.print("Enter a decimal number: ");
        int decimalNumber = scanner.nextInt();
        System.out.println("The octal form of " + decimalNumber + " = " + decimalToOctal(decimalNumber));
        System.out.println(); // Line break

        // Stack concatenation
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        System.out.print("Enter numbers for the first stack (seperated by comma): ");
        String[] elements1 = scanner.next().split(",");
        for (String elem : elements1) {
            s1.push(Integer.parseInt(elem.trim()));
        }
        System.out.print("Enter numbers for the second stack (seperated by comma): ");
        String[] elements2 = scanner.next().split(",");
        for (String elem : elements2) {
            s2.push(Integer.parseInt(elem.trim()));
        }
        Stack<Integer> concatenatedStack = concatenate(s1, s2);
        System.out.println("First stack: " + s1);
        System.out.println("Second stack: " + s2);
        System.out.println("Concatenated stack: " + concatenatedStack);
        System.out.println(); // Line break

        // Stack comparison
        Stack<Integer> s3 = new Stack<>();
        System.out.print("Enter numbers for the third stack to compare with the first stack (seperated by comma): ");
        String[] elements3 = scanner.next().split(",");
        for (String elem : elements3) {
            s3.push(Integer.parseInt(elem.trim()));
        }
        System.out.println("The identical status of the third stack to the first stack (true = identical, false = not identical): " + stackIdentifier(s1, s3));

        scanner.close();
    }
}
