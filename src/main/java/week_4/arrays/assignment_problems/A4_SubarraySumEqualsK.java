package week_4.arrays.assignment_problems;

import java.util.HashMap;
import java.util.Map;

public class A4_SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int count = 0;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        A4_SubarraySumEqualsK solution = new A4_SubarraySumEqualsK();

        int[] nums1 = {1, 1, 1};
        System.out.println("Input: [1, 1, 1], k = 2 -> Output: " + solution.subarraySum(nums1, 2));

        int[] nums2 = {1, -1, 0};
        System.out.println("Input: [1, -1, 0], k = 0 -> Output: " + solution.subarraySum(nums2, 0));
    }
}