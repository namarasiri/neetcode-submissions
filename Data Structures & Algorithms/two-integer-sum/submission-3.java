class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> outPut = new HashMap<>();

        for (int x = 0; x < nums.length; x++) {

            int diff = target - nums[x];

            if (outPut.containsKey(diff)) {
                return new int[] {outPut.get(diff), x};
            }

            outPut.put(nums[x], x);

        }

        return new int[] {};
    }
}
