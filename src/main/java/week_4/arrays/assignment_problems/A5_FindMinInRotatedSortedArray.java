package week_4.arrays.assignment_problems;

public class A5_FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        A5_FindMinInRotatedSortedArray solution = new A5_FindMinInRotatedSortedArray();

        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Input: [3, 4, 5, 1, 2] -> Output: " + solution.findMin(nums1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Input: [4, 5, 6, 7, 0, 1, 2] -> Output: " + solution.findMin(nums2));

        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Input: [11, 13, 15, 17] -> Output: " + solution.findMin(nums3));
    }
}