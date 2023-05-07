package leetcode.backtrack;
//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
//
//candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
//对于给定的输入，保证和为 target 的不同组合数少于 150 个。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/combination-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/combination-sum
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//执行用时：
//2 ms
//, 在所有 Java 提交中击败了
//78.49%
//的用户
//内存消耗：
//42.8 MB
//, 在所有 Java 提交中击败了
//5.02%
//的用户
//通过测试用例：
//160 / 160



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class p2 {
    public static void main(String[] args) {
        int [] candidates = new int[]{2,3,6,7};
        System.out.println(combinationSum(candidates,7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combination = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        BT(candidates,target,0,combination,stack,0);
        return combination;
    }

    public static void BT(int[] candidates, int target,int begin, List<List<Integer>> combination , Deque<Integer> stack,int sum ){
        if(sum == target){
            combination.add(new ArrayList<>(stack));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i = begin ; i < candidates.length;i++){
            stack.offerLast(candidates[i]);
            BT(candidates,target,i,combination,stack,sum+candidates[i]);//避免重复的情况
            stack.pollLast();
        }
    }
}
