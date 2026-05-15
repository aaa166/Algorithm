//Given two sorted arrays nums1 and nums2 of size m and n respectively, return 
//the median of the two sorted arrays. 
//
// The overall run time complexity should be O(log (m+n)). 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,3], nums2 = [2]
//Output: 2.00000
//Explanation: merged array = [1,2,3] and median is 2.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1,2], nums2 = [3,4]
//Output: 2.50000
//Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics Array Binary Search Divide and Conquer 👍 32210 👎 3583


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        if (nums1.length == 0) return medianSingle(nums2);
        if (nums2.length == 0) return medianSingle(nums1);

        int len = nums1.length + nums2.length;
        boolean isOdd = len % 2 != 0;
        int[] merge = new int[len];
        int a = 0;
        int b = 0;

        for (int i = 0; i < merge.length / 2 + 1; i++) {

            if (a < nums1.length && (b >= nums2.length || nums1[a] < nums2[b])) {
                merge[i] = nums1[a++];
                if (a == nums1.length) {
                    System.arraycopy(nums2, b, merge, i + 1, nums2.length - b);
                    break;
                }
            } else {
                merge[i] = nums2[b++];
                if (b == nums2.length) {
                    System.arraycopy(nums1, a, merge, i + 1, nums1.length - a);
                    break;
                }
            }
        }

        if (isOdd)
            return merge[len / 2];
        else
            return (merge[len / 2] + merge[len / 2 - 1]) / 2.0;
    }
    private double medianSingle(int[] nums) {
        int n = nums.length;
        if (n % 2 == 1) return nums[n / 2];
        return (nums[n / 2] + nums[n / 2 - 1]) / 2.0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
