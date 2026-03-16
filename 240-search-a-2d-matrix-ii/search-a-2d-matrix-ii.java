class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int r = 0;
        int c = col - 1;
        while(r < row && c >= 0){
            if(matrix[r][c] == target){
                return true;
            }else if(target < matrix[r][c]){
                c = c - 1;
            }else{
                r = r + 1;
            }
        }
        return false;
    }
}