import java.util.Arrays;

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
        int [] arr1 = {1, 2, 3, 4, 5, 6};
        int [] arr2 = {10, 34, 65, 57};
        int [] arr3 = {1, 2};

        System.out.println("Minimum gap between digits in arr1: " + minGap(arr1, arr1.length));
        System.out.println("Minimum gap between 3 first digits of arr2: " + minGap(arr2, arr2.length - 1));
        System.out.println("Minimum gap between digits of arr3: " + minGap(arr3, arr3.length - 1));
    }
      
}
