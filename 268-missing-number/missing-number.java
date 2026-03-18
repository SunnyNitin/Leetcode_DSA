class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int x = n; // to include nth term.
        for(int i = 0; i < n; i ++){
            x = x ^ i ^ nums[i];
        }
        return x;

        /* 
        int n = nums.length;
        int excptedSum = n * (n + 1) / 2;
        int currentSum = 0;
        for(int i = 0; i < n; i ++){
            currentSum += nums[i];
        }
        return (excpetedSum - currentSum);
        */
    }
}