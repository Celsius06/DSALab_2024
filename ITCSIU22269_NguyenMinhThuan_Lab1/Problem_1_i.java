import java.util.Scanner;

public class Problem_1_i {

  public static int arrayToNumber(int[] digitsArr) {
    int num = 0;
    int pow = 1;

    for (int i = digitsArr.length - 1; i >= 0; i--) {
      num += digitsArr[i] * pow;
      pow *= 10;
    }

    return num;
  }

  public static void main(String[] args) {
    try (Scanner sc = new Scanner(System.in)) {
        System.out.print("Enter the number of digits: ");
        int numDigits = sc.nextInt();

        if (numDigits <= 0) {
            System.out.println("Error: Please enter a positive number of digits.");
            return; 
        }

        int[] digitsArr = new int[numDigits];

        System.out.print("Enter the digits (separated by spaces): ");
        for (int i = 0; i < numDigits; i++) {
            digitsArr[i] = sc.nextInt();
        }

        System.out.print("Numbers from array: ");
        for (int digit : digitsArr) {
            System.out.print(digit + " "); 
        }
        System.out.println();

        int number = arrayToNumber(digitsArr);
        System.out.println("Converted number: " + number);
      }
    }
}