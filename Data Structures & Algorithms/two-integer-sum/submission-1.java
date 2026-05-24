class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int [] ans = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int x = 0; x < nums.length; x++) {

            int diff = target - nums[x];

            if (map.containsKey(diff)) {
                ans[1] = x;
                ans[0] = map.get(diff);
                break;
            } else {
                map.put(nums[x], x);
            }

        }

        return ans;
    }
}
