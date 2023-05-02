package leetcode;

public class p45 {
    private class Solution {
        int min = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        public int getMinimumDifference(TreeNode root) {
            if(root==null){
                return min;
            }
            getMinimumDifference(root.left);
            min = Math.min(Math.abs(root.val - left), min);
            left=root.val;
            getMinimumDifference(root.right);
            return min;
        }

    }
}
