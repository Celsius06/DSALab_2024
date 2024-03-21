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
      int[] digitsArr1 = {2, 0, 1, 8};
      System.out.print("Numbers from array1: ");
      for (int digit : digitsArr1) {
        System.out.print(digit + " ");  // Add a space after each digit
      }
      System.out.println();
    }
  }