class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == nums[mid]){
                return mid;
            }
            // left side sorted.
            if(nums[start] <= nums[mid]){
                // can ans be found in the left side?
                if(target >= nums[start] && target < nums[mid]){
                    end = mid -1;
                } else{
                    start = mid + 1;
                }
            }
            // right side is sorted.
            else{
                // ans can be found in the right side?
                if(target > nums[mid] && target <= nums[end]){
                    start = mid + 1;
                } else{
                    end = end - 1;
                }
            }
        }
        return ans;
    }
}