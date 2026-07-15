class Solution {
    public int longestSubstring(String s, int k) {
        int maxLen = 0;
        
        // Try finding the longest substring with exactly `targetUnique` characters
        // Since there are only lowercase English letters, the max is 26.
        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] counts = new int[26];
            int windowStart = 0;
            int uniqueInWindow = 0;
            int charsAtLeastK = 0;
            
            for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
                // 1. Add the new character to the window
                int endIdx = s.charAt(windowEnd) - 'a';
                if (counts[endIdx] == 0) {
                    uniqueInWindow++;
                }
                counts[endIdx]++;
                if (counts[endIdx] == k) {
                    charsAtLeastK++;
                }
                
                // 2. Shrink window if we have more unique characters than our target
                while (uniqueInWindow > targetUnique) {
                    int startIdx = s.charAt(windowStart) - 'a';
                    if (counts[startIdx] == k) {
                        charsAtLeastK--;
                    }
                    counts[startIdx]--;
                    if (counts[startIdx] == 0) {
                        uniqueInWindow--;
                    }
                    windowStart++;
                }
                
                // 3. Update max length if our window is perfectly valid
                // (It has exactly the target unique characters, and ALL of them appear >= k times)
                if (uniqueInWindow == targetUnique && uniqueInWindow == charsAtLeastK) {
                    maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
                }
            }
        }
        
        return maxLen;
    }
}