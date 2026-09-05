package arrays.assigment_problems;

import java.util.Arrays;

/**
 * Problem A2: Maximum Subarray
 *
 * Finds the contiguous subarray with the largest sum using Kadane's algorithm
 * in O(n) time and O(1) extra space.
 */
public class MaximumSubarray {

    /**
     * Finds maximum contiguous subarray sum using Kadane's algorithm.
     *
     * @param nums array of integers (may contain negative numbers)
     * @return maximum subarray sum
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend current subarray or start fresh
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input:  " + Arrays.toString(nums1));
        System.out.println("Output: " + maxSubArray(nums1));

        System.out.println("\n--- Test Case 2 ---");
        int[] nums2 = {-3, -1, -2};
        System.out.println("Input:  " + Arrays.toString(nums2));
        System.out.println("Output: " + maxSubArray(nums2));
    }
}
