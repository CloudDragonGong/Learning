package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public static TreeNode createTree(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < nums.length) {
            TreeNode parent = queue.poll();

            if (nums[i] != null) {
                TreeNode left = new TreeNode(nums[i]);
                parent.left = left;
                queue.offer(left);
            }
            i++;

            if (i < nums.length && nums[i] != null) {
                TreeNode right = new TreeNode(nums[i]);
                parent.right = right;
                queue.offer(right);
            }
            i++;
        }

        return root;
    }
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            levels.add(level);
        }

        System.out.println(levels);
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
