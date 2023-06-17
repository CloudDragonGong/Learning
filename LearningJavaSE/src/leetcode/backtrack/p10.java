package leetcode.backtrack;

import java.util.Set;

public class p10 {
    public static void main(String[] args) {

    }
    public static void  solveSudoku(char[][] board) {
        Set<Character> [][] grids = new Set[3][3];
        Set<Character> [] col = new Set[9];
        Set<Character> [] row = new Set[9];

        // 初始化setgrids，col,row
        for ( int i = 0 ; i < 9;i++){
            for ( int j = 0 ; j < 9 ; j ++){
                grids[(int)(1+i)/3-1 ][(int)(1+j)/3-1].add(board[i][j]);
                row[i].add(board[i][j]);
                col[j].add(board[i][j]);
            }
        }

    }
    public static void backtrack(char[][] board,Set<Character> [][] grids,Set<Character>[] col , Set<Character> [] row){
        
    }
}
