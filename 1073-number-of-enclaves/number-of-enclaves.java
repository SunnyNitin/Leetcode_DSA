class Solution {
    public int numEnclaves(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++){
                //if land cell, lying on extreme row or column.
                if(grid[i][j] == 1 && isAtExtreme(i, j, r, c)){
                    //sink all the connected land cells
                    sinkLand(grid, i, j);
                }
            }
        }
        // count the number of remaining land cells
        int enclaves = 0;
        for(int[] row: grid){
            for(int val: row){
                if(val == 1){
                    enclaves ++;
                }
            }
        }
        return enclaves;
    }

    private void sinkLand(int[][] grid, int i, int j){
        // return if out of bounds.
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        // return if its sea cell.
        if(grid[i][j] == 0){
            return;
        }
        // sink the land cell.
        grid[i][j] = 0;
        // spread out all in four directions.
        sinkLand(grid, i, j-1); //left.
        sinkLand(grid, i, j+1); //right.
        sinkLand(grid, i-1, j); //up.
        sinkLand(grid, i+1, j); //down.
    }

    private boolean isAtExtreme(int i, int j, int r, int c){
        return i == 0 || j == 0 || i == r - 1 || j == c - 1;
    }
}