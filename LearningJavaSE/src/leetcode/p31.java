package leetcode;

public class p31 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1,null,2,null,3});
        System.out.println(isBalanced(tree));
    }
//    给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//    本题中，一棵高度平衡二叉树定义为：
//
//    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。


    public static boolean isBalanced(TreeNode root) {
         if(root==null){
             return false;
         }
         if(root.left==null&&root.right==null){
             return true;
         }
         int left = countLevel(root.left);
         int right = countLevel(root.right);
         if(Math.abs(left-right)<=1){
             return isBalanced(root.left) && isBalanced(root.right);
         }
         else{
             return false;
         }
    }

    public static int countLevel(TreeNode node){
        if(node == null){
            return 0 ;
        }
        return Math.max(countLevel(node.left),countLevel(node.right))+1;
    }
}
