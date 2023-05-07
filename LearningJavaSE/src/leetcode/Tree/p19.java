package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class p19 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] max = maxSlidingWindow(nums, 3);
        for (int i = 0; i < max.length; i++) {
            System.out.println(max[i]);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] output = new int[nums.length - k + 1];
        output[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            output[i - k + 1] = nums[deque.peekFirst()];
        }
        return output;
    }
}
