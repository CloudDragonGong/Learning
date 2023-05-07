package leetcode.Tree;

import java.util.PriorityQueue;
import java.util.Collections;

//滑动窗口最大值的问题，这段代码是超时的，本质上的时间复杂度还是O(mn)
public class p18 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] max = maxSlidingWindow(nums, 3);
        for (int i = 0; i < max.length; i++) {
            System.out.println(max[i]);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
            for (int j = 0; j < k; j++) {
                queue.add(nums[i + j]);
            }
            max[i] = queue.peek();
        }
        return max;
    }
}
