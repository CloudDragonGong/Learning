package leetcode.backtrack;
//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
//
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
//
//每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/n-queens
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

// 心得
// clone方法坑死人


//执行用时：
//11 ms
//, 在所有 Java 提交中击败了
//7.30%
//的用户
//内存消耗：
//43.1 MB
//, 在所有 Java 提交中击败了
//5.04%
//的用户
//通过测试用例：
//9 / 9
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class p9 {
    public static void main(String[] args) {
        List<List<String>> outPut = solveNQueens(4);
        System.out.println(outPut);
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> outPut = new ArrayList<>();
        Stack<String> subOutPut = new Stack<>();
        boolean[][] index = new boolean[n][n];
        backtrack(outPut,subOutPut,n,index);
        return outPut;
    }

    public static void backtrack(List<List<String>> outPut, Stack<String> stack, int n, boolean[][] index){
        if(stack.size()==n){
            outPut.add(new ArrayList<>(stack));
            return;
        }
        for(int i=0;i<index.length;i++){
            if(!index[stack.size()][i]){
                stack.push(generateString(i,n));
                backtrack(outPut,stack,n,caculateIndex(i,index,stack.size()-1));
                stack.pop();
            }
        }
    }
    public static String generateString(int index,int n){
        StringBuffer str = new StringBuffer();
        for(int i=0;i<n;i++){
            if(i!=index) {
                str.append('.');
            }
            else{
                str.append('Q');
            }
        }
        return str.toString();
    }
    public static boolean[][] caculateIndex(int i,boolean[][]index,int layer ){
        boolean[][] copyindex = new boolean[index.length][index.length];
        for(int a = 0 ; a < index.length; a ++){
            for(int b = 0; b < index.length;b++){
                copyindex[a][b]=index[a][b];
            }
        }
        for(int j =0;j<copyindex.length;j++){
            copyindex[j][i]=true;
        }
        for(int j=layer,k=i,l=i;j<copyindex.length;j++,k--,l++){
            if(k>=0) copyindex[j][k]=true;
            if(l<copyindex.length) copyindex[j][l]=true;
        }
        return copyindex;
    }
}
