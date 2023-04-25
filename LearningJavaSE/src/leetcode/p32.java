package leetcode;

public class p32 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1,null,2,null,3});
        System.out.println(isBalanced(tree));
    }

    public static boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        if(!isBalanced(root.left)){
            return false;
        }
        if(!isBalanced(root.right)){
            return false;
        }
        return Math.abs(countLevel(root.left)-countLevel(root.right))<=1;
    }
    public static int countLevel(TreeNode node){
        if(node == null){
            return 0 ;
        }
        return Math.max(countLevel(node.left),countLevel(node.right))+1;
    }
}
