package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class p24 {
    //    给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode Root = root;
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            root = queue.pollFirst();
            TreeNode rev = root.left;
            root.left = root.right;
            root.right = rev;
            if (root.left != null) {
                queue.offerLast(root.left);
            }
            if (root.right != null) {
                queue.offerLast(root.right);
            }
        }
        return Root;
    }

}
