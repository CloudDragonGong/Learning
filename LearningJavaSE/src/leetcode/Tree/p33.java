package leetcode.Tree;

public class p33 {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root){
        return recv(root)!=-1;
    }

    public static int recv(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = recv(node.left);
        int right = recv(node.right);
        if(left==-1||right==-1){
            return -1;
        }
        if(Math.abs(left-right)<=1){
            return Math.max(left,right)+1;
        }
        else{
            return -1;
        }
    }
}
