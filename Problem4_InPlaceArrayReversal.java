public class Problem4_InPlaceArrayReversal {

    static class InPlaceArrayReversal {
        public void reverse(int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        public void printArray(int[] arr) {
            System.out.print("[");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i < arr.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        InPlaceArrayReversal reverser = new InPlaceArrayReversal();
        int[] arr1 = {11, 22, 33, 44};
        reverser.reverse(arr1);
        reverser.printArray(arr1);
        System.out.println("---");
        int[] arr2 = {1, 2, 3, 4, 5};
        reverser.reverse(arr2);
        reverser.printArray(arr2);
    }
}