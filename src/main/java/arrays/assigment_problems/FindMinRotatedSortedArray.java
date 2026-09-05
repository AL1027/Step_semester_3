package arrays.assigment_problems;

import java.util.Arrays;

/**
 * Problem A5: Find Minimum in Rotated Sorted Array
 *
 * Finds the minimum element in an array of unique elements, originally sorted
 * in ascending order and rotated at an unknown pivot, using modified binary search in O(log n) time.
 */
public class FindMinRotatedSortedArray {

    /**
     * Finds the minimum element using binary search.
     *
     * @param nums rotated sorted array of unique integers
     * @return minimum element in the array
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Inflection point / minimum lies in the right half
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Input:  " + Arrays.toString(nums1));
        System.out.println("Output: " + findMin(nums1));

        System.out.println("\n--- Test Case 2 ---");
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Input:  " + Arrays.toString(nums2));
        System.out.println("Output: " + findMin(nums2));

        System.out.println("\n--- Test Case 3 ---");
        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Input:  " + Arrays.toString(nums3));
        System.out.println("Output: " + findMin(nums3));
    }
}
