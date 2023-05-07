package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class p25 {
    //代码无法通过
    public static void main(String[] args) {
        Integer[] nums = {2,3,3,4,5,5,4,null,null,8,9,null,null,9,8};
        TreeNode tree = createTree(nums);
        System.out.println(isSymmetric(tree));
    }

    //给你一个二叉树的根节点 root ， 检查它是否轴对称。
    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return false;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        int currentSize = deque.size();
        while(currentSize!=0){
            for(int i = 0 ; i < currentSize;i++){
                TreeNode node = deque.pollFirst();
                if(node.left!=null){
                    deque.offerLast(node.left);
                }
                else{
                    if(node.right!=null){
                        deque.offerLast(new TreeNode(Integer.MAX_VALUE));
                    }
                }
                if(node.right!=null){
                    deque.offerLast(node.right);
                }
                else{
                    if(node.left!=null){
                        deque.offerLast(new TreeNode(Integer.MAX_VALUE));
                    }
                }
            }
            if(deque.size()%2!=0){
                return false;
            }
            else{
                int [] elements= new int[deque.size()];
                int index = 0 ;
                for(TreeNode x: deque){
                    elements[index++]= x.val;
                }
                for(int i= 0 ,j = elements.length-1; i<j;i++,j--){
                    if(!(elements[i] == elements[j])){
                        return false;
                    }
                }
            }
            currentSize=deque.size();
        }
        return true;
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


}
