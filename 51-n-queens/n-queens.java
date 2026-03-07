class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> boards = new ArrayList<List<String>>();

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag = new HashSet<>();
        Set<Integer> antiDiag = new HashSet<>();

        char[][] game = new char[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j=0; j<n; j++){
                game[i][j] = '.';
            }
        }
        backTrack(0, cols, diag, antiDiag, boards, n, game);
        return boards;
    }

    public void backTrack(int row,
    Set<Integer> cols,
    Set<Integer> diags,
    Set<Integer> antiDiags,
    List<List<String>> boards,
    int n,
    char [][] game){
        // base case
        if(row == n){
            //n^3
            //add current game to boards
            List<String> board = new ArrayList<>();
            for(char[] r : game){
                board.add(new String(r));
            }
            boards.add(board);
            return;
        }

        for(int col = 0; col < n; col++){
            if(cols.contains(col)){
                //queen cannot sit there
                continue;
            }

            int diag = col - row;
            if(diags.contains(diag)){
                //queen cannot sit there
                continue;
            }

            int antiDiag = col + row;
            if(antiDiags.contains(antiDiag)){
                //queen cannot sit there
                continue;
            }

            cols.add(col);
            diags.add(diag);
            antiDiags.add(antiDiag);

            game[row][col] = 'Q';

            backTrack(row + 1, cols, diags, antiDiags, boards, n, game);

            cols.remove(col);
            diags.remove(diag);
            antiDiags.remove(antiDiag);

            game[row][col] = '.';            
        }
    }
}