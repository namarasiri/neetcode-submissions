class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int lo = 0;
        int hi = m;

        while (lo <= hi) {

            int i = lo + (hi - lo) / 2;
            int j = (m + n + 1) / 2 -i;

            int nums1LeftMax  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int nums2LeftMax  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {

                if ((m + n) % 2 == 1) {

                    return Math.max(nums1LeftMax, nums2LeftMax);

                } else {
                    return (Math.max(nums1LeftMax, nums2LeftMax)
                          + Math.min(nums1RightMin, nums2RightMin)) / 2.0;
                }
            } else if (nums1LeftMax > nums2RightMin) {

                hi = i - 1;

            } else {
                lo = i + 1;
            }

        }
        
        return -1;
    }
}
