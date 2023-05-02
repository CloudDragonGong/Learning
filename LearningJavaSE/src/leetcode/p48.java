package leetcode;

public class p48 {
    public static void main(String[] args) {
        TreeNode tree  = TreeNode.createTree(new Integer[]{0,-1000000000,1000000000});
        TreeNode.printLevelOrder(tree);
        Solution48 solution = new Solution48();
        System.out.println(solution.lowestCommonAncestor(tree,tree.findNode(tree,-1000000000),tree.findNode(tree,1000000000)).val);
    }
}
class Solution48 {
    //30 / 30 个通过测试用例
    //状态：通过
    //执行用时: 5 ms
    //内存消耗: 43.1 MB
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        //再通过这种比大小的时候，需要考虑好数的大小
        if((double)(root.val-p.val)*(root.val-q.val) <= 0 ){
            return root;
        }
        if(root.val<p.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        else {
            return lowestCommonAncestor(root.left,p,q);
        }
    }
}