class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Use a Deque as a stack to keep track of indices
        Deque<Integer> stack = new ArrayDeque<>();

        // 1. Find the Previous Less Element (PLE) for each item
        for (int i = 0; i < n; i++) {
            // Pop elements greater than or equal to current element
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // If stack is empty, there is no smaller element to the left
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // 2. Find the Next Less Element (NLE) for each item
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements strictly greater than current element
            // (Using strictly greater '>' handles duplicate values properly)
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            // If stack is empty, there is no smaller element to the right
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // 3. Calculate total sum
        long sum = 0;
        long mod = 1_000_000_007;

        for (int i = 0; i < n; i++) {
            // Number of valid subarrays where arr[i] is the minimum
            long count = (long) (i - left[i]) * (right[i] - i);
            
            // Add contribution to sum and apply modulo
            sum = (sum + count * arr[i]) % mod;
        }

        return (int) sum;
    }
}