package leetcode;

import sun.reflect.generics.tree.Tree;

//给定二叉树的根节点 root ，返回所有左叶子之和。
public class p36 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(sumOfLeftLeaves(tree));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countLeaves(root);
    }

    public static int countLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return countLeaves(root.right) + root.left.val;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }
}
