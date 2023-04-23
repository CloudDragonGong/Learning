package leetcode;
import java.util.ArrayDeque;
import java.util.Deque;
public class p27 {
//    给定一个二叉树，找出其最大深度。
//
//    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数

    public static void main(String[] args) {

    }
    public static int maxDepth(TreeNode root) {
        Deque<TreeNode> deque  = new ArrayDeque<>();
        if(root!=null){
            deque.offerLast(root);
        }
        int num = 0 ;
        int currentSize = deque.size();
        while(!(currentSize==0)){
            for(int i = 0 ; i < currentSize;i++){
                TreeNode node = deque.pollFirst();
                if(node.left!=null){
                    deque.offerLast(node.left);
                }
                if(node.right!=null){
                    deque.offerLast(node.right);
                }
            }
            num++;
            currentSize=deque.size();
        }
        return num;
    }
}
