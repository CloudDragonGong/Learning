package leetcode.Tree;

//给你一个二叉树的根节点 root ， 检查它是否轴对称。
public class p26 {
    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        return !(root == null) && isMirror(root, root);
    }

    //递归解法
    public static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
