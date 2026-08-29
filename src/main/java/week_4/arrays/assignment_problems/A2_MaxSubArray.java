package week_4.arrays.assignment_problems;

public class A2_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        A2_MaxSubArray solution = new A2_MaxSubArray();

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: [-2, 1, -3, 4, -1, 2, 1, -5, 4] -> Output: " + solution.maxSubArray(nums1));

        int[] nums2 = {-3, -1, -2};
        System.out.println("Input: [-3, -1, -2] -> Output: " + solution.maxSubArray(nums2));
    }
}