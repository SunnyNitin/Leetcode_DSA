class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int p = 0;
        int e = n - 1;
        while(p < e && s.charAt(p) == s.charAt(e)){
            char ch = s.charAt(p);
            // delete prefix.
            while(p <= e && s.charAt(p) == ch){
                p++;
            }
            // delete suffix.
            while(p <= e && s.charAt(e) == ch){
                e--;
            }
        }
        return (e - p + 1);
    }
}