class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case check
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        int n = s.length();

        // If the string is shorter than the required total length, return empty
        if (n < totalLen) {
            return result;
        }

        // Map to store the frequency of each word in the words array
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // We run 'wordLen' number of independent sliding windows.
        // This ensures we cover all possible starting offsets.
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int count = 0; // Number of valid words matched in the current window
            
            // Map to store the frequency of words in the current window
            Map<String, Integer> currentCount = new HashMap<>();

            while (right + wordLen <= n) {
                // Extract the next word of size 'wordLen'
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // If it's a valid word that exists in our target list
                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    count++;

                    // If we have more of this word than needed, we must shrink the window from the left
                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If our window contains exactly the total number of words, we found a match!
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // The word is not in our target list. 
                    // This breaks our valid sequence, so we reset the window completely.
                    currentCount.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}