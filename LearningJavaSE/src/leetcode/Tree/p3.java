package leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class position{
    private int first;
    private int second;

    position(int first,int second ){
        this.first=first;
        this.second=second;
    }


    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}
public class p3 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer,position> map = new HashMap<>();
        List<List<Integer>> L = new ArrayList<>();

        for(int a=0; a<nums.length-1;a++){
            for(int b =a+1; b < nums.length;b++){

                map.put(nums[a]+nums[b],new position(a,b));
            }
        }
        for(int c =0;c< nums.length-1;c++){
            for(int d =c+1;d<nums.length;d++){
                if(map.containsKey(target-nums[c]-nums[d])){
                    int a = map.get(target-nums[c]-nums[d]).getFirst();
                    int b = map.get(target-nums[c]-nums[d]).getSecond();
                    if (c != a && c != b && d!= a  && d!= b ){
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[a]);
                        l.add(nums[b]);
                        l.add(nums[c]);
                        l.add(nums[d]);
                        L.add(l);
                    }
                }
            }
        }
        return L;
    }
}
