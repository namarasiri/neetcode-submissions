class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int left = 0, right = 0, sum = 0;

         List<List<Integer>> res = new ArrayList<>();
         Arrays.sort(nums);

        for (int i=0; i < nums.length; i++) {

            if (nums[i] > 0) break;

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            left = i + 1;
            right = nums.length - 1;

            while (left < right) {

                sum = nums[i] + nums[left] + nums[right];

                if (sum > 0) {
                  right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }

            }

        }

        return res;
        
    }
}
