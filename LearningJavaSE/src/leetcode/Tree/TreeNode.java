package leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }


    public TreeNode findNode(TreeNode root, int val) {
        if (root == null) { // 如果根节点为空，返回null
            return null;
        }

        if (root.val == val) { // 如果当前节点的值等于目标值，返回当前节点
            return root;
        }

        // 否则递归地在左子树和右子树中查找目标节点
        TreeNode left = findNode(root.left, val);
        TreeNode right = findNode(root.right, val);

        if (left != null) { // 如果在左子树中找到了目标节点，返回左子树中的节点
            return left;
        } else { // 否则在右子树中查找目标节点，返回右子树中的节点
            return right;
        }
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

    public static List<String> levelOrder(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    result.add("null");
                } else {
                    result.add(String.valueOf(node.val));
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        System.out.println(result);
        return result;
    }
}
