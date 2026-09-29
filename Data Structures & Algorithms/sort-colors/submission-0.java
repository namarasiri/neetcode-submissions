class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length -1;
        int tmp = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < (n - i); j++) {

                if (nums[j] > nums[j + 1]) {

                    tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;

                }

            }

        }
        
    }
}