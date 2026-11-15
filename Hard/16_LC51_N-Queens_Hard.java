class Solution {

    List<List<String>> result = new ArrayList<>();

    char[][] board;

    public List<List<String>> solveNQueens(int n) {
       
       board = new char[n][n];

       for(int i = 0; i < n; i++)
       {
        Arrays.fill(board[i], '.');
       }
       backtrack(0,n);
       return result;
    }

    public void backtrack(int row, int n){
        if(row == n){
            List<String> solution = new ArrayList<>();

            for (int i = 0; i < n; i++){
                solution.add(new String(board[i]));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++){
            if(isSafe(row,col,n)){
                board[row][col] = 'Q';

                backtrack(row + 1, n);

                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, int n){
        for (int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        int i = row - 1;
        int j = col - 1; 

        while (i >= 0 && j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }

            i--;
            j--;
        }

        i = row - 1;
        j = col + 1;

        while(i >= 0 && j < n){
            if(board[i][j] == 'Q'){
                return false;
            }

            i--;
            j++;
        }
        return true;
    }
}
