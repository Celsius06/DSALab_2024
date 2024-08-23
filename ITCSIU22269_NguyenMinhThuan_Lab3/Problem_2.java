import java.util.*;

public class Problem_2 {
    public static class infixToPostfix {
        // Check if a character is an operator (+, -, *, /)
        private static boolean isOperator(char c) {
            return (c == '+' || c == '-' || c == '*' || c == '/');
        }

        // Check the priority of the operators
        private static int operatorPriority(char c) {
            switch (c) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
            }
            return -1;
        }

        private static boolean isVariable(char c) {
            return Character.isLetter(c);
        }

        public static String convert(String infix) {
            StringBuilder postfix = new StringBuilder();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < infix.length(); i++) {
                char c = infix.charAt(i);

                // If it's a digit or variable, append to postfix
                if (Character.isDigit(c) || isVariable(c)) {
                    postfix.append(c);
                } else if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix.append(stack.pop());
                    }
                    stack.pop(); // Remove the '('
                } else if (isOperator(c)) {
                    while (!stack.isEmpty() && operatorPriority(c) <= operatorPriority(stack.peek())) {
                        postfix.append(stack.pop());
                    }
                    stack.push(c);
                }
            }

            while (!stack.isEmpty()) {
                postfix.append(stack.pop());
            }

            return postfix.toString();
        }
    }

    public static class PostfixEvaluator {
        private static int evaluatePostfix(String postfix, Map<Character, Integer> variableValues) {
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < postfix.length(); i++) {
                char c = postfix.charAt(i);

                if (Character.isDigit(c)) {
                    stack.push(c - '0'); // Convert char to int value
                } else if (Character.isLetter(c)) {
                    stack.push(variableValues.get(c)); // Get the value of the variable
                } else {
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    switch (c) {
                        case '+':
                            stack.push(val2 + val1);
                            break;
                        case '-':
                            stack.push(val2 - val1);
                            break;
                        case '*':
                            stack.push(val2 * val1);
                            break;
                        case '/':
                            stack.push(val2 / val1);
                            break;
                    }
                }
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String infixExpression = scanner.nextLine();

        String postfixExpression = infixToPostfix.convert(infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);

        // Ask for variable values
        Map<Character, Integer> variableValues = new HashMap<>();
        for (char c : infixExpression.toCharArray()) {
            if (Character.isLetter(c) && !variableValues.containsKey(c)) {
                System.out.print("Enter the value for " + c + ": ");
                int value = scanner.nextInt();
                variableValues.put(c, value);
            }
        }

        // Evaluate the postfix expression
        int result = PostfixEvaluator.evaluatePostfix(postfixExpression, variableValues);
        System.out.println("The result of the expression = " + result);

        scanner.close();
    }
}
