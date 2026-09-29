Design and Analysis of Algorithms Azhimamatova Meerim COMFCI-24


---

1. RECURSIVE FIBONACCI

Java Code:
public static int fibonacciRecursive(int n) {
    if (n <= 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    }
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

Examples:
- Input: n = 0 -> Output: 0
- Input: n = 4 -> Output: 3
- Input: n = 5 -> Output: 5

Call Tree Structure for fib(4):

                     fib(4)
                   /        \
              fib(3)        fib(2)
             /      \       /      \
        fib(2)    fib(1)  fib(1)  fib(0)
       /      \
  fib(1)    fib(0)

Explanation:
In recursive Fibonacci, the function calls itself to calculate fib(n-1) and fib(n-2). The left branch is evaluated first down to the base cases (n = 0 or n = 1). The time complexity is O(2^n) because of overlapping subproblems (e.g., fib(2) is recomputed multiple times). The space complexity is O(n) due to the system call stack.

---

2. ITERATIVE BINARY SEARCH

Java Code:
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

Examples and Step-by-Step Trace:

Example 1: Target = 23 in arr = [2, 5, 8, 12, 16, 23, 38, 56, 72, 91]
- Step 1: low = 0, high = 9, mid = 4, arr[4] = 16. Since 16 < 23, low becomes 5.
- Step 2: low = 5, high = 9, mid = 7, arr[7] = 56. Since 56 > 23, high becomes 6.
- Step 3: low = 5, high = 6, mid = 5, arr[5] = 23. Target found at index 5.

Example 2: Target = 10 in arr = [10, 20, 30, 40, 50]
- Step 1: low = 0, high = 4, mid = 2, arr[2] = 30. Since 30 > 10, high becomes 1.
- Step 2: low = 0, high = 1, mid = 0, arr[0] = 10. Target found at index 0.

Example 3: Target = 12 in arr = [3, 9, 15, 21]
- Step 1: low = 0, high = 3, mid = 1, arr[1] = 9. Since 9 < 12, low becomes 2.
- Step 2: low = 2, high = 3, mid = 2, arr[2] = 15. Since 15 > 12, high becomes 1.
- Step 3: low (2) > high (1), loop terminates. Target not found, returns -1.

Explanation:
Iterative binary search uses two pointers (low and high) defining the search window. Each iteration halves the search space by adjusting low or high. Time complexity is O(log n). Space complexity is O(1) as it uses a constant amount of extra memory.

---

3. RECURSIVE BINARY SEARCH

Java Code:
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

Explanation:
Recursive binary search applies Divide-and-Conquer strategy by replacing the loop with recursive function calls.

Recurrence Relation:
T(n) = T(n/2) + O(1)

According to the Master Theorem (Case 2), the time complexity is O(log n). The space complexity is O(log n) because each recursive call allocates a frame on the call stack.
