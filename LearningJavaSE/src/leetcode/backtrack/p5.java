package leetcode.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
public class p5 {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0 ; i <= nums.length;i++){
            BT(nums,list,stack,0,i);
        }
        return list;
    }

    public static void BT(int [] nums ,List<List<Integer>> list , Deque<Integer> stack ,int begin,int num ){
        if(stack.size()==num){
            list.add(new ArrayList<>(stack));
            return;
        }
        for(int i=begin;i<nums.length;i++){
            stack.offerLast(nums[i]);
            BT(nums,list,stack,i+1,num);
            stack.pollLast();
        }
    }
}

//优秀算法
class Solutionp5 {
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}

/*
上面的代码中，
dfs
(
cur
,
�
)
dfs(cur,n) 参数表示当前位置是
cur
cur，原序列总长度为
�
n。原序列的每个位置在答案序列中的状态有被选中和不被选中两种，我们用
�
t 数组存放已经被选出的数字。在进入
dfs
(
cur
,
�
)
dfs(cur,n) 之前
[
0
,
cur
−
1
]
[0,cur−1] 位置的状态是确定的，而
[
cur
,
�
−
1
]
[cur,n−1] 内位置的状态是不确定的，
dfs
(
cur
,
�
)
dfs(cur,n) 需要确定
cur
cur 位置的状态，然后求解子问题
dfs
(
�
�
�
+
1
,
�
)
dfs(cur+1,n)。对于
cur
cur 位置，我们需要考虑
�
[
cur
]
a[cur] 取或者不取，如果取，我们需要把
�
[
cur
]
a[cur] 放入一个临时的答案数组中（即上面代码中的
�
t），再执行
dfs
(
�
�
�
+
1
,
�
)
dfs(cur+1,n)，执行结束后需要对
�
t 进行回溯；如果不取，则直接执行
dfs
(
�
�
�
+
1
,
�
)
dfs(cur+1,n)。在整个递归调用的过程中，
cur
cur 是从小到大递增的，当
cur
cur 增加到
�
n 的时候，记录答案并终止递归。可以看出二进制枚举的时间复杂度是
�
(
2
�
)
O(2
n
 )。

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/subsets/solution/zi-ji-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */