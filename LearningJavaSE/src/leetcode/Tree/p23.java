package leetcode.Tree;


//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
import java.util.*;

public class p23 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(TreeNode root) {
        //这段代码决定了传入空指针的效果
        if(root==null){
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> queue =new ArrayDeque<>();
        List<List<Integer>> order= new ArrayList<>();
        queue.offer(root);
        int currentNum = queue.size();
        while(currentNum!=0){
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < currentNum;i++){
                root=queue.poll();
                level.add(root.val);
                if(root.left!=null){
                    queue.offer(root.left);
                }
                if(root.right!=null){
                    queue.offer(root.right);
                }
            }
            currentNum= queue.size();
            order.add(level);
        }
        return order;
    }
}
