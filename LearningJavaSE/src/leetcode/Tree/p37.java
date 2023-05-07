package leetcode.Tree;
//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
//
//        假设二叉树中至少有一个节点。


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class p37 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1,2,3,4,null,5,6,null,null,7});
        System.out.println(findBottomLeftValue(tree));
    }

    public static int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        ArrayList<TreeNode> array = new ArrayList<>();
        deque.offerLast(root);
        int currentNum = deque.size();
        while(currentNum>0){
            array.clear();
            for(int  i =  0 ; i < currentNum ; i++){
                TreeNode node = deque.pollFirst();
                array.add(node);
                if(node==null){
                    continue;
                }
                if(node.left!=null)
                    deque.offerLast(node.left);
                if(node.right !=null)
                    deque.offerLast(node.right);
            }
            currentNum=deque.size();
        }
        return array.get(0).val;
    }
}
