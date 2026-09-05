package arrays.assigment_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem A3: 3Sum
 *
 * Finds all unique triplets [nums[i], nums[j], nums[k]] such that
 * i, j, k are all distinct indices and nums[i] + nums[j] + nums[k] == 0.
 * Operates in O(n^2) time with strict duplicate avoidance.
 */
public class ThreeSum {

    /**
     * Solves 3Sum using sorting and a two-pointer inward scan.
     *
     * @param nums input integer array
     * @return 2D array of distinct triplets summing to 0
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        // Sort array to enable two-pointer traversal and duplicate skipping
        Arrays.sort(nums);
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // If the current number is greater than 0, three positive numbers cannot sum to 0
            if (nums[i] > 0) {
                break;
            }

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicates for the second element
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the third element
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets.toArray(new int[triplets.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Input:  " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.deepToString(threeSum(nums1)));

        System.out.println("\n--- Test Case 2 ---");
        int[] nums2 = {0, 0, 0};
        System.out.println("Input:  " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.deepToString(threeSum(nums2)));
    }
}
