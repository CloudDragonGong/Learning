package leetcode;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;

//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
//
//创建一个根节点，其值为 nums 中的最大值。
//递归地在最大值 左边 的 子数组前缀上 构建左子树。
//递归地在最大值 右边 的 子数组后缀上 构建右子树。
//返回 nums 构建的 最大二叉树 。
//
// 
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/maximum-binary-tree
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class p40 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,6,0,5};
        TreeNode tree1 = constructMaximumBinaryTree(nums);
        TreeNode.printLevelOrder(tree1);

//        ArrayList<Integer> nums = new ArrayList<>();
//        for(int i = 0 ; i < 10 ; i ++){
//            nums.add(100-i);
//            System.out.println(findMaxIndex(nums));
//        }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        ArrayList<Integer> numsArray  = new ArrayList<>();
        for(int i  = 0 ; i < nums.length ; i ++){
            numsArray.add(nums[i]);
        }
        return constructMaxBT(numsArray);
    }
    public static TreeNode constructMaxBT(ArrayList<Integer> nums){
        if(nums.size()==0){
            return null;
        }
        int index  = findMaxIndex(nums);
        TreeNode node  = new TreeNode(nums.get(index));
        node.left = constructMaxBT(new ArrayList<>(nums.subList(0,index)));
        node.right = constructMaxBT(new ArrayList<>(nums.subList(index+1,nums.size())));
        return node;
    }


    public static int findMaxIndex ( ArrayList<Integer> nums){
        Integer max  = nums.get(0);
        for(Integer a : nums){
            if(a>max){
                max =a ;
            }
        }
        return nums.indexOf(max);
    }
}
