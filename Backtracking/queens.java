public class queens{
    public static void nQueens(char board[][], int row){
        // Base case: If all queens are placed
        if(row == board.length){
            printBoard(board);
            return;
        }
        // Try placing queen in each column of the current row
        for(int j=0; j<board.length; j++){
            // Check if it's safe to place a queen at (row, j)
            if(isSafe(board, row, j)){
                board[row][j] = 'Q'; // Place the queen
                nQueens(board, row + 1); // Recur to place the next queen
                board[row][j] = '-'; // Backtrack: remove the queen
            }
        }
    }
    public static boolean isSafe(char board[][], int row, int col){
        //check vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //check left diagonal
        for(int i= row-1, j= col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        //check right diagonal
        for(int i=row-1, j= col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true; // Safe to place the queen
    }
    public static void printBoard(char board[][]){
        System.out.println("---------ChessBoard---------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args){
        int n=4;
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='-';
            }
        }
        nQueens(board,0);
    }
}