package leetcode;
//给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
//
//你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
//
// 
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/search-in-a-binary-search-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class p44 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{4,2,7,1,3});
        TreeNode node1 = searchBST(tree,2);
        TreeNode node2 = searchBST(tree,2);
        TreeNode.printLevelOrder(node1);
        TreeNode.printLevelOrder(node2);
    }
    public static TreeNode searchBST(TreeNode node, int val) {
        if(node==null){
            return null;
        }
        if(node.val == val){
            return node;
        }
        TreeNode left = BFS(node.left,val);
        TreeNode right = BFS(node.right,val);
        if(left==null&& right==null){
            return null;
        }
        else if(left!=null&&right!=null){
            return left;
        }
        else{
            return left!=null ? left:right;
        }
    }

    public static TreeNode BFS ( TreeNode node, int val){
        if(node==null){
            return null;
        }
        if(node.val == val){
            return node;
        }
        TreeNode left = BFS(node.left,val);
        TreeNode right = BFS(node.right,val);
        if(left==null&& right==null){
            return null;
        }
        else if(left!=null&&right!=null){
            return left;
        }
        else{
            return left!=null ? left:right;
        }
    }
}
