package leetcode.Tree;

public class p28 {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            int left = maxDepth(root.left);
            int right= maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }

}
