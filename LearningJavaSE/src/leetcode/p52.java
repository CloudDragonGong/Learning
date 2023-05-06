package leetcode;

import netscape.security.UserTarget;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
//你可以按 任何顺序 返回答案。
//https://leetcode.cn/problems/combinations/
//执行结果：
//通过
//显示详情
//查看示例代码
//添加备注
//
//执行用时：
//15 ms
//, 在所有 Java 提交中击败了
//43.75%
//的用户
//内存消耗：
//44 MB
//, 在所有 Java 提交中击败了
//13.58%
//的用户
//通过测试用例：
//27 / 27




public class p52 {
    public static void main(String[] args) {
        List<List<Integer>> list = combine(1,1);
        System.out.println(list);
    }
    public static List<List<Integer>> combine(int n, int k) {
        if(n<k||n<0){
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(n,k,1,stack,list);
        return list;
    }
    public static void dfs(int n , int k , int begin , Deque<Integer> stack , List<List<Integer>> list){
        if(stack.size()>=k){//这里一开始写成了2
            list.add(new ArrayList<>(stack));
            return;
        }
        for(int i = begin ; i <= n-k+stack.size()+1 ;i ++){
            //循环是横向
            //递归是纵向，是重复的操作
            stack.offerLast(i);
            dfs(n,k,i+1,stack,list);
            stack.pollLast();
            //dfs的功能就是定义为每次出来stack都是没有添加，所以这里只要弹出一个就够了，因为dfs递归已经弹完了
        }
    }
}
