package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderList = new ArrayList<>();
        preorder(preorderList,root);
        return preorderList;
    }
    public static void  preorder (List<Integer> preorderList , TreeNode root){
        if(root==null){
            return ;
        }
        preorderList.add(root.val);
        preorder(preorderList,root.left);
        preorder(preorderList,root.right);
    }
}
public class p22 {

}
