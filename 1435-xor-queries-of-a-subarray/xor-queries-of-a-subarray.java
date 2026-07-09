class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] pXOR = new int[arr.length];
        pXOR[0] = arr[0];
        for(int i = 1; i < arr.length; i ++){
            pXOR[i] = arr[i] ^ pXOR[i - 1];
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i ++){
            int leftIdx = queries[i][0], rightIdx = queries[i][1];
            if(leftIdx == 0){
                ans[i] = pXOR[rightIdx];
            }else{
                ans[i] = pXOR[rightIdx] ^ pXOR[leftIdx - 1];
            }
        }
        return ans;
    }
}