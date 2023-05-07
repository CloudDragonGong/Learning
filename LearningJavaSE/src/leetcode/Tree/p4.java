package leetcode.Tree;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class p4 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> sumList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] < target) {
                continue;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) {
                    continue;
                }
                int a = j + 1;
                int b = nums.length - 1;
                while (a < b) {
                    if (b != nums.length - 1 && nums[b] == nums[b + 1]) {
                        b--;
                    } else if (a != j + 1 && nums[a] == nums[a - 1]) {
                        a++;
                    } else if ((long) nums[i] + nums[j] + nums[a] + nums[b] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[a]);
                        list.add(nums[b]);
                        sumList.add(list);
                        a++;
                        b--;
                    } else if ((long) nums[i] + nums[j] + nums[a] + nums[b] > target) {
                        b--;
                    } else {
                        a++;
                    }
                }
            }
        }
        return sumList;
    }


    public static void main(String[] args) {
        List<List<Integer>> sumList;
        int[] nums = {0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000
        };
        sumList = fourSum(nums, 1000000000);
        System.out.println(sumList);
    }
}
