class Solution {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length -1;
        int mid = 0;

        while (left <= right) {

            mid = left + (right - left) /2;

            if (target == nums[mid]) {

                return mid;

            }

            // checking left half sorted
            if (nums[left] <= nums[mid]) {

                if (target > nums[mid] || target < nums[left]) {

                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            } else { // right half is sorted

                if (target < nums[mid] || target > nums[right]) {

                    right = mid - 1;

                } else {
                    left = mid + 1;
                }

            }

        }
        
        return -1;
    }
}
