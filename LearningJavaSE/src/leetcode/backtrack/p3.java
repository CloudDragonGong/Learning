package leetcode.backtrack;
//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的每个数字在每个组合中只能使用 一次 。
//
//注意：解集不能包含重复的组合。 
//
// 
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/combination-sum-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//执行用时：
//4 ms
//, 在所有 Java 提交中击败了
//45.38%
//的用户
//内存消耗：
//41.5 MB
//, 在所有 Java 提交中击败了
//90.69%
//的用户
//通过测试用例：
//176 / 176
import java.util.*;

public class p3 {
    public static void main(String[] args) {
        int[] candidates = new int[]{};

        System.out.println(combinationSum2(candidates,5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combination = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.sort(candidates);
        for(int i = 0; i< candidates.length;i++){
            System.out.print(candidates[i]);
            System.out.print(" ");
        }
        BT(candidates,target,0,0,combination,stack);
        return combination;
    }
    public static void BT(int[] candidates , int target , int begin , int sum , List<List<Integer>> combination , Deque<Integer> stack ){
        if(sum == target){
            combination.add(new ArrayList<>(stack));
            return;
        }
        if(sum > target){
            return;
        }
        int left = 0;
        for(int i = begin ; i < candidates.length;i++){
            if(left==candidates[i]) continue;
            stack.offerLast(candidates[i]);
            BT(candidates,target,i+1,sum+candidates[i],combination,stack);
            stack.pollLast();
            left = candidates[i];
        }
    }
}
