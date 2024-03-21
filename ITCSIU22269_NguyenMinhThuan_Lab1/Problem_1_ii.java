import java.util.Arrays;

public class Problem_1_ii {

    public static class medianCalculator {
        public static double findMedian (int[] nums) {
            Arrays.sort(nums);

            int mid = nums.length / 2;
            if (nums.length % 2 == 0) {
                return(nums[mid - 1] + nums[mid]) / 2.0;
            } else {
                return nums[mid];
            }
        }
    }

    public static void main(String[] args) {
        int [] num1 = {1, 3, 5, 7, 9, 11};
        int [] num2 = {6, 8, 10, 12, 14, 16};

        System.out.print("Median of num1 = " + medianCalculator.findMedian(num1));
        System.out.print("\n");
        System.out.print("Median of num2 = " + medianCalculator.findMedian(num2));
    }
}
