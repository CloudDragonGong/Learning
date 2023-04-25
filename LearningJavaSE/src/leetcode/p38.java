package leetcode;

public class p38 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1,2,3});
        System.out.println(hasPathSum(tree,5));
    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return ifPathSum(root,targetSum,0);
    }

    public static boolean ifPathSum(TreeNode node,int targetSum,int sum){
        if(node == null){
            return false;
        }
        if(node.left==null && node.right == null){
            return targetSum == sum+node.val;
        }
        return ifPathSum(node.left,targetSum,sum+node.val) || ifPathSum(node.right,targetSum,sum+ node.val);
    }
}
