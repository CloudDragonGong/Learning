package leetcode.Tree;

import java.util.ArrayList;

//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
//
//如果树中有不止一个众数，可以按 任意顺序 返回。
//
//假定 BST 满足如下定义：
//
//结点左子树中所含节点的值 小于等于 当前节点的值
//结点右子树中所含节点的值 大于等于 当前节点的值
//左子树和右子树都是二叉搜索树
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/find-mode-in-binary-search-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//
public class p46 {
    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        TreeNode tree = TreeNode.createTree(new Integer[]{1,1,1,null,null,null,2});
        TreeNode.printLevelOrder(tree);
        int[] mode = solution.findMode(tree);
        for (int i = 0; i < mode.length; i++) {
            System.out.println(mode[i]);
        }
    }
}


//23 / 23 个通过测试用例
//状态：通过
//执行用时: 0 ms
//内存消耗: 42.5 MB
class Solution46 {
    TreeNode left;
    int current;
    int max;
    ArrayList<Integer> arrays = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        BFS(root);
        int[] mode = new int[arrays.size()];
        for (int i = 0; i < arrays.size(); i++) {
            mode[i] = arrays.get(i);
        }
        return mode;
    }

    public void BFS(TreeNode root) {
        if (root == null) {
            return;
        }
        BFS(root.left);
        update(root);
        BFS(root.right);
    }

    public void update(TreeNode root) {
        if (left == null) {
            arrays.add(root.val);
            current++;
            left=root;
            max=1;
            return;
        }
        if(left.val!=root.val){
            current=0;
        }
        current++;
        if (current > max) {
            arrays.clear();
            arrays.add(root.val);
            max = current;
        } else if (current == max) {
            if (arrays.get(arrays.size() - 1) != root.val) {
                arrays.add(root.val);
            }
        }
        left = root;
    }
}