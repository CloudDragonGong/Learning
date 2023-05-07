package leetcode.Tree;

import java.util.*;

public class p20 {
    //给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
    public static void main(String[] args) {
        int[] nums= {4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums,2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int index : nums ){
            map.put(index,map.getOrDefault(index,0)+1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(queue.size()==k) {
                if (queue.peek()[1] < entry.getValue()) {
                    queue.poll();
                    queue.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }
            else if(queue.size()<k){
                queue.offer(new int[]{entry.getKey(), entry.getValue()});
            }
            else{
                System.out.println("error");
            }
        }
        int []out = new int[k];
        for(int i = 0 ; i < k; i++){
            out[i]=queue.poll()[0];
        }
        return out;
    }
}
