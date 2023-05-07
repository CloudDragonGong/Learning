package leetcode.Tree;

//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
//
//一般来说，删除节点可分为两个步骤：
//
//首先找到需要删除的节点；
//如果找到了，删除它。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/delete-node-in-a-bst
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//执行结果：
//通过
//显示详情
//查看示例代码
//添加备注
//
//执行用时：
//0 ms
//, 在所有 Java 提交中击败了
//100.00%
//的用户
//内存消耗：
//44.2 MB
//, 在所有 Java 提交中击败了
//5.01%
//的用户
//通过测试用例：
//92 / 92
public class p50 {

    public static void main(String[] args) {
        TreeNode tree = TreeNode.createTree(new Integer[]{5, 3, 6, 2, 4, null, 7});
        TreeNode.levelOrder(tree);
        TreeNode.printLevelOrder(tree);

        Solution50 solution50 = new Solution50();
        solution50.deleteNode(tree, 7);
        TreeNode.levelOrder(tree);
        TreeNode.printLevelOrder(tree);

    }

}

class Solution50 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode left = null;
        TreeNode p = root;
        while (true) {
            if (p == null) {
                return root;
            } else if (p.val == key) {
                TreeNode q = p.right;
                if (q == null) {
                    if (left == null) {
                        return root.left;
                    } else {
                        if (left.left == p) {
                            left.left = p.left;
                        } else {
                            left.right = p.left;
                        }
                        return root;
                    }
                }
                TreeNode qleft = p;
                while (q.left != null) {
                    qleft = q;
                    q = q.left;
                }
                if (qleft.left == q) qleft.left = q.right;
                else {
                    qleft.right = q.right;
                }
                p.val = q.val;
                return root;
            } else {
                left = p;
                if (p.val > key) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
        }
    }
}