package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
//解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
// 
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/subsets-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class p6 {
    public static void main(String[] args) {
        int [] nums = {0};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        dfs(nums,list,subList,0,false);
        return list;
    }

    public static void dfs(int[] nums, List<List<Integer>> list, List<Integer> subList, int cur,boolean comeIn) {
        if (cur == nums.length) {
            list.add(new ArrayList<>(subList));//这里记得额外开辟空间
            return;
        }
        if(!comeIn&&cur>0&&nums[cur-1]==nums[cur]) {
            dfs(nums, list, subList, cur + 1, false);
            return;
        }
        subList.add(nums[cur]);
        dfs(nums, list, subList, cur + 1,true);
        subList.remove(subList.size() - 1);
        dfs(nums, list, subList, cur + 1,false);
    }

    public static void BT(int[] nums, List<List<Integer>> list, Deque<Integer> stack, int begin, int num) {

    }
}
