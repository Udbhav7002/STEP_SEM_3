public class L5_RotateArray {
    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }

        int n = nums.length;
        k = k % n;
        if (k < 0) {
            k += n;
        }

        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = newArray[i];
        }

        return nums;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        printArray(rotateArray(nums1, 3));

        int[] nums2 = {1, 2};
        printArray(rotateArray(nums2, 3));
    }
}
