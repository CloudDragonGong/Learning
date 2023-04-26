package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class p39 {
    public static void main(String[] args) {
        int [] inorder = new int[]{9,3,15,20,7};
        int [] postorder = new int[]{9,15,7,20,3};
        TreeNode tree = buildTree(inorder,postorder);
        TreeNode.printLevelOrder(tree);
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        ArrayList<Integer> inorderArray =  new ArrayList<>();
        ArrayList<Integer> postorderArray = new ArrayList<>();
        for(int i  = 0 ;  i < inorder.length;i++){
            inorderArray.add(inorder[i]);
            postorderArray.add(postorder[i]);
        }
        return buildChildTree(inorderArray,postorderArray);
    }

    public static TreeNode buildChildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder){
        if(inorder.size()==0|| postorder.size()==0){
            return null;
        }
        TreeNode root = new TreeNode(postorder.get(postorder.size()-1));
        int index = inorder.indexOf(root.val);
        ArrayList<Integer> inorderPass1 = new ArrayList<>(inorder.subList(0,index));
        ArrayList<Integer> inorderPass2 = new ArrayList<>(inorder.subList(index+1,inorder.size()));
        ArrayList<Integer> postorderPass1 = new ArrayList<>(postorder.subList(0,index));
        ArrayList<Integer> postorderPass2 = new ArrayList<>(postorder.subList(index,postorder.size()-1));
        root.left = buildChildTree(inorderPass1,postorderPass1);
        root.right = buildChildTree(inorderPass2,postorderPass2);
        return root;
    }
}
