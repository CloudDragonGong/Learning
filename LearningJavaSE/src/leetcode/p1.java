package leetcode;

import java.util.HashMap;
import java.util.Map;

public class p1 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int sum=0;
        Map<Integer,Integer> countMap = new HashMap<>();
        for(int a : A){
            for(int b : B ){
                countMap.put(a+b,countMap.getOrDefault(a+b,0)+1);
            }
        }
        for(int a :C){
            for(int b : D){
                sum+=countMap.getOrDefault(-(a+b),0);
            }
        }
        return sum;
    }
}
