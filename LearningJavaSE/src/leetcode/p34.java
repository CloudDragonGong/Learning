package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
/*
给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

叶子节点 是指没有子节点的节点。
 */
public class p34 {
    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{1,2,3,null,5});
        List<String> list= binaryTreePaths(tree);
        System.out.println(list);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        returnPath(root,list);
        return list;
    }


    public static void returnPath(TreeNode node,List<String> list){
        if(node==null){
            return;
        }
        if(list.size()==0){
            if(node.left==null&&node.right==null){
                String newString  = String.valueOf(node.val);
                list.add(newString);
            }
            else if(node.left==null||node.right==null){
                String newString  = String.valueOf(node.val);
                list.add(newString);
                returnPath(node.left==null ? node.right : node.left , list);
            }
            else{
                String newString1 = String.valueOf(node.val);
                String newString2 = String.valueOf(node.val);
                list.add(newString1);
                returnPath(node.left,list);
                list.add(newString2);
                returnPath(node.right,list);
            }
        }
        else {
            if (node.left == null && node.right == null) {
                String s = list.get(list.size() - 1);
                s = s + "->" + String.valueOf(node.val);
                list.set(list.size() - 1, s);
                return;
            }
            if (node.left == null || node.right == null) {
                String s = list.get(list.size() - 1);
                s = s + "->" + String.valueOf(node.val);
                list.set(list.size() - 1, s);
                returnPath(node.left == null ? node.right : node.left, list);
                return;
            }
            String s = list.get(list.size() - 1);
            String newString = s + "->" + String.valueOf(node.val);
            list.set(list.size()-1,newString);
            returnPath(node.left,list);
            list.add(newString);
            returnPath(node.right, list);
        }

    }
}
