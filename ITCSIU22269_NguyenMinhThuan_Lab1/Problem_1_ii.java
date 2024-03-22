import java.util.Arrays;
import java.util.Scanner;

public class Problem_1_ii {

    public static class MedianCalculator {
        public static double findMedian(int[] nums) {
            Arrays.sort(nums);

            int mid = nums.length / 2;
            if (nums.length % 2 == 0) {
                return (nums[mid - 1] + nums[mid]) / 2.0;
            } else {
                return nums[mid];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the first array:");
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        System.out.print("Enter " + n1 + " elements for the first array:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter the number of elements in the second array:");
        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        System.out.print("Enter " + n2 + " elements for the second array:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        sc.close();

        System.out.println("Median of num1 = " + MedianCalculator.findMedian(arr1));
        System.out.println("Median of num2 = " + MedianCalculator.findMedian(arr2));
    }
}
