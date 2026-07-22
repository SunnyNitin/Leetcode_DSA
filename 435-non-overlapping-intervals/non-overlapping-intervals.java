class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }
        // sort the interval based on the end time.
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int previous_interval = 0;
        for(int i = 1; i < intervals.length; i ++){
            /* If the start time of the next interval is greater than or equal to 
            the end time of the current interval, then we can keep it. */
            if(intervals[i][0] >= intervals[previous_interval][1]){
                previous_interval = i;
                count ++;
            }
        }
        // return the number of intervals to remove.
        return intervals.length - count;
    }
}