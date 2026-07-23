class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        
        // Bundle the start time, end time, and profit together
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        
        // Sort the jobs by their endTime in ascending order
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        
        // TreeMap stores <EndTime, MaxProfitAtThatTime>
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0, 0); // Base case: 0 profit at time 0
        
        for (int[] job : jobs) {
            // Find the highest profit we can get from jobs that end before or exactly when the current job starts
            int currentProfit = job[2] + dp.floorEntry(job[0]).getValue();
            
            // If taking this job gives us more profit than the highest profit recorded so far, add it to the map
            if (currentProfit > dp.lastEntry().getValue()) {
                dp.put(job[1], currentProfit);
            }
        }
        
        // The last entry will contain the absolute maximum profit possible
        return dp.lastEntry().getValue();
    }
}