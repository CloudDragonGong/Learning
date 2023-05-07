package leetcode.Tree;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.*;

public class p47 {
    public static void main(String[] args) {
        solution47_2 solution = new solution47_2();
        TreeNode tree = TreeNode.createTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode node1 = tree.findNode(tree,5);
        TreeNode node2 = tree.findNode(tree,4);
        TreeNode node = solution.lowestCommonAncestor(tree,node1,node2);
        System.out.println(node.val);
    }
}


class Solution47_1 {
    //递归写法

    //执行用时：
    //6 ms
    //, 在所有 Java 提交中击败了
    //99.94%
    //的用户
    //内存消耗：
    //42.5 MB
    //, 在所有 Java 提交中击败了
    //73.93%
    //的用户
    //通过测试用例：
    //31 / 31

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}


class solution47_2{
    //循环写法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        //子节点key，父节点value
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        Deque<TreeNode>deque = new ArrayDeque<>();
        Set<TreeNode> set = new HashSet<>();
        map.put(root,null);
        deque.offerLast(root);

        while(!map.containsKey(p)||!map.containsKey(q)){
            root = deque.pollFirst();
            if(root != null){
                if(root.left != null){
                    deque.offerLast(root.left);
                    map.put(root.left, root);
                }
                if(root.right != null){
                    deque.offerLast(root.right);
                    map.put(root.right, root);
                }
            }
        }

        while(p!=null){
            set.add(p);
            p = map.get(p);
        }

        while(!set.contains(q)){
            q = map.get(q);
        }
        return q;
    }
}


