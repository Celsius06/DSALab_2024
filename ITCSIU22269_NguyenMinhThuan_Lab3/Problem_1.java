import java.util.Stack;

public class Problem_1 {
    // Convert a decimal string to octal form
    public static String decimalToOctal (int decimal) {
        return Integer.toOctalString(decimal);
    }

    // Concatenate two stacks 
    public static <T> Stack<T> concatenate (Stack<T> s1, Stack<T> s2) {
        Stack<T> newStack = new Stack<T>();
        newStack.addAll(s1);
        newStack.addAll(s2);
        return newStack;
    }

    // Determine if the contents of one stack are identical to that of another
    public static <T> boolean stackIdentifier(Stack<T> s1, Stack<T> s2) {
        return s1.equals(s2);
    }

    // Main
    public static void main (String[] args) {
        // Convert a decimal string to octal form
        int decimalTestNum = 642024;
        System.out.println("The octal form of " + decimalTestNum + " is " + decimalToOctal(decimalTestNum));
        System.out.println(" ");    // Line break

        // Concatenate two stacks 
        Stack<Integer> s1 = new Stack<>();
        s1.push(1);
        s1.push(2);
        Stack<Integer> s2 = new Stack<>();
        s2.push(3);
        s2.push(4);
        Stack<Integer> concatenatedStack = concatenate(s1, s2);
        System.out.println("First stack: " + s1);
        System.out.println("Second` stack: " + s2);
        System.out.println("Concatenated stack: " + concatenatedStack);
        System.out.println(" ");    // Line break

        // Determine if the contents of one stack are identical to that of another
        Stack<Integer> s3 = new Stack<>();
        s3.push(1);
        s3.push(2);
        System.out.println("Does the two given stacks identical? (true = identical, false = not identlcal): " + stackIdentifier(s1, s3));
    }
}