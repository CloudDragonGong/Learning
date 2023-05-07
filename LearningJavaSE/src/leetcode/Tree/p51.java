package leetcode.Tree;
//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
//
//高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
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
//42.2 MB
//, 在所有 Java 提交中击败了
//5.03%
//的用户
//通过测试用例：
//31 / 31
public class p51 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode tree = sortedArrayToBST(nums);
        TreeNode.printLevelOrder(tree);
        TreeNode.levelOrder(tree);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return BST(nums, 0, nums.length - 1);
    }

    public static TreeNode BST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums, low, mid - 1);
        root.right = BST(nums, mid + 1, high);
        return root;
    }
}
