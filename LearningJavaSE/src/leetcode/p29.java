package leetcode;

public class p29 {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{2, null, 3, null, 4, null, 5, null, 6});
        System.out.println(minDepth(tree));
    }

    public static int minDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return Math.min(left, right) + 1;

    }
}
