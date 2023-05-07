package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class p35 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1,2,3,null,5});
        List<String> list= binaryTreePaths(tree);
        System.out.println(list);
    }

    public static List<String> binaryTreePaths(TreeNode root){
        List<String> list = new ArrayList<>();
        if(root== null){
            return list;
        }
        solve(root,"",list);
        return list;
    }


    public static void solve ( TreeNode node , String pass , List<String> list){
        if(node == null){
            return;
        }
        pass += node.val;
        if(node.left==null&&node.right==null){
            list.add(pass);
        }
        else{
            solve(node.left,pass+"->",list);
            solve(node.right,pass+"->",list);
        }
    }
}
