package arrays.assigment_problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem A4: Subarray Sum Equals K
 *
 * Counts the total number of contiguous subarrays whose elements sum to k.
 * Uses running prefix sums with a hash map of prefix-sum frequencies in O(n) time and O(n) space.
 */
public class SubarraySumEqualsK {

    /**
     * Finds the total number of subarrays summing to k.
     *
     * @param nums array of integers (may contain negative numbers)
     * @param k target sum
     * @return count of subarrays summing to k
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Map stores: prefixSum -> frequency
        Map<Integer, Integer> prefixSumFrequencies = new HashMap<>();
        // Base case: prefix sum of 0 has occurred once (empty prefix before index 0)
        prefixSumFrequencies.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in prefix map, each occurrence forms a valid subarray
            if (prefixSumFrequencies.containsKey(currentSum - k)) {
                count += prefixSumFrequencies.get(currentSum - k);
            }

            prefixSumFrequencies.put(currentSum, prefixSumFrequencies.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Output: " + subarraySum(nums1, k1));

        System.out.println("\n--- Test Case 2 ---");
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Output: " + subarraySum(nums2, k2));
    }
}
