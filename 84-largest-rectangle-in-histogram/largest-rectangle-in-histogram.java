class Solution {
    public int largestRectangleArea(int[] heights) {
        int ns[] = findNextSmaller(heights);
        int ps[] = findPrevSmaller(heights);
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<heights.length;i ++){
            int h = heights[i];
            int w = ns[i] - ps[i] -1;
            max = Math.max(max, (h*w));
        }
        return max;
    }

    public int[] findNextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int res[] = new int[n];
        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i % n]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = n;
            }else{
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    public int[] findPrevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int res[] = new int[n];
        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i % n]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;    
    }
}