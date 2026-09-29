public class Solution {

    // 1. RECURSIVE FIBONACCI
    public static int fibonacciRecursive(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // 2. ITERATIVE BINARY SEARCH
    public static int binarySearchIterative(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // 3. RECURSIVE BINARY SEARCH
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1);
        } else {
            return binarySearchRecursive(arr, target, mid + 1, high);
        }
    }

    // Helper method to start recursion easily
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    // MAIN METHOD (RUNNING ALL 3 EXAMPLES)
    public static void main(String[] args) {
        System.out.println("--- 1. FIBONACCI EXAMPLES ---");
        System.out.println("fib(0) = " + fibonacciRecursive(0));
        System.out.println("fib(4) = " + fibonacciRecursive(4));
        System.out.println("fib(5) = " + fibonacciRecursive(5));
        System.out.println();

        System.out.println("--- 2 & 3. BINARY SEARCH EXAMPLES ---");
        int[] arr1 = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int[] arr2 = {10, 20, 30, 40, 50};
        int[] arr3 = {3, 9, 15, 21};

        System.out.println("Example 1 (Search 23):");
        System.out.println("Iterative result index: " + binarySearchIterative(arr1, 23));
        System.out.println("Recursive result index: " + binarySearchRecursive(arr1, 23));
        System.out.println();

        System.out.println("Example 2 (Search 10):");
        System.out.println("Iterative result index: " + binarySearchIterative(arr2, 10));
        System.out.println("Recursive result index: " + binarySearchRecursive(arr2, 10));
        System.out.println();

        System.out.println("Example 3 (Search 12 - not in array):");
        System.out.println("Iterative result index: " + binarySearchIterative(arr3, 12));
        System.out.println("Recursive result index: " + binarySearchRecursive(arr3, 12));
    }
}