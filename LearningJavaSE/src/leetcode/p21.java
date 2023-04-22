package leetcode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
public class p21 {
    public static void main(String[] args) {

    }
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        preorder(preorderList,root);
        return preorderList;
    }

    public static void  preorder (List<Integer> preorderList , TreeNode root){
        if(root==null){
            return ;
        }
        preorderList.add(root.val);
        preorder(preorderList,root.left);
        preorder(preorderList,root.right);
    }
}
