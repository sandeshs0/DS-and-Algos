// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     public boolean isSafe(int row, int col, char[][] board) {
//         //horizontal
//         for(int j=0; j<board.length; j++) {
//             if(board[row][j] == 'Q') {
//                 return false;
//             }
//         }
       
//         //vertical
//         for(int i=0; i<board.length; i++) {
//             if(board[i][col] == 'Q') {
//                 return false;
//             }
//         }
       
//         //upper left
//         int r = row;
//         for(int c=col; c>=0 && r>=0; c--, r--) {
//             if(board[r][c] == 'Q') {
//                 return false;
//             }
//         }
       
//         //upper right
//         r = row;
//         for(int c=col; c<board.length && r>=0; r--, c++) {
//             if(board[r][c] == 'Q') {
//                 return false;
//             }
//         }
       
//         //lower left
//         r = row;
//         for(int c=col; c>=0 && r<board.length; r++, c--) {
//             if(board[r][c] == 'Q') {
//                 return false;
//             }
//         }
       
//         //lower right
//         for(int c=col; c<board.length && r<board.length; c++, r++) {
//             if(board[r][c] == 'Q') {
//                 return false;
//             }
//         }
       
//         return true;
//     }
   
//     public void saveBoard(char[][] board, List<List<String>> allBoards) {
//         String row = "";
//         List<String> newBoard = new ArrayList<>();
       
//         for(int i=0; i<board.length; i++) {
//             row = "";
//             for(int j=0; j<board[0].length; j++) {
//                 if(board[i][j] == 'Q')
//                     row += 'Q';
//                 else
//                     row += '.';
//             }
//             newBoard.add(row);
//         }
       
//         allBoards.add(newBoard);
//     }
   
//     public void helper(char[][] board, List<List<String>> allBoards, int col) {
//         if(col == board.length) {
//             saveBoard(board, allBoards);
//             return;
//         }
       
//         for(int row=0; row<board.length; row++) {
//             if(isSafe(row, col, board)) {
//                 board[row][col] = 'Q';
//                 helper(board, allBoards, col+1);
//                 board[row][col] = '.';
//             }
//         }
//     }
   
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> allBoards = new ArrayList<>();
//         char[][] board = new char[n][n];
       
//         helper(board, allBoards, 0);
//         return allBoards;
//     }
//     public static void main(String[] args) {
//         Solution s= new Solution();
//         System.out.println(s.solveNQueens(4));
//     }
//  }
 
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = n-1;
        int missing  = compute(arr[n-1], n);
        while(left <= right) {
            int mid = left + (right-left)/2;
            missing = compute(arr[mid], mid+1);
            
            if(missing >= k) right = mid-1;
            else left = mid+1;
        }
        
        // Right -> -1;
        if(right == -1) return k;
        return arr[right] + k-compute(arr[right], right+1);
        
    }
    
    int compute(int actual, int expected){
        return actual - expected;
    }
    public static void main(String args[]) {
        int values[] = {1,2,5,6}; // values of items
        Solution s = new Solution();
 System.out.println(s.findKthPositive(values,4));
    }
}