package leetcode;

public class p42 {
    public static void main(String[] args) {

    }
    public TreeNode constructMaximumBinaryTree(int[] nums){
        return construct(nums,0,nums.length-1);
    }
    public TreeNode construct(int[] nums , int left ,int right){
        if(left > right){
            return null;
        }
        int best = left ;
        for(int i = left+1 ; i< right+1;i++){
            if(nums[best] < nums[i]){
                best = i ;
            }
        }
        TreeNode root = new TreeNode ( nums[best]);
        root.left = construct(nums,left,best-1);
        root.right = construct(nums,best+1,right);
        return root;
    }
}
