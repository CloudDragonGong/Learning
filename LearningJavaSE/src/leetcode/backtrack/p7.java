package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p7 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> arrays = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        dfs(nums, isVisited, new ArrayList<>(), arrays);
        return arrays;
    }

    public static void dfs(int[] nums, boolean[] isVisited, List<Integer> array, List<List<Integer>> arrays) {
        if (array.size() == nums.length) {
            arrays.add(new ArrayList<>(array));//注意别写成下面的形式
            //arrays.add(array);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] ||( i > 0 && (nums[i] == nums[i - 1]) && !isVisited[i - 1])) {
                //isVisited[i-1]就是查看前面那个有没有用过，通过保留一种顺序来达到剪枝操作
                continue;
            }
            isVisited[i] = true;
            array.add(nums[i]);
            dfs(nums, isVisited, array, arrays);
            array.remove(array.size() - 1);
            isVisited[i] = false;
        }
    }
}
