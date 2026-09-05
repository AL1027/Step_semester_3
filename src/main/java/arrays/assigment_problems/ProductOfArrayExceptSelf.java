package arrays.assigment_problems;

import java.util.Arrays;

/**
 * Problem A1: Product of Array Except Self
 *
 * Computes an array where answer[i] is the product of every element in nums
 * except nums[i], without using division, in O(n) time and O(1) extra space
 * beyond the output array.
 */
public class ProductOfArrayExceptSelf {

    /**
     * Calculates prefix and suffix products in two passes.
     *
     * @param nums input integer array
     * @return answer array where answer[i] is product of all elements except nums[i]
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: Forward pass accumulating running prefix product
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: Backward pass multiplying in running suffix product
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("--- Test Case 1 ---");
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Input:  " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums1)));

        System.out.println("\n--- Test Case 2 ---");
        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Input:  " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums2)));
    }
}
