class Solution {
    public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> outPut = new HashMap<>();

        for (int x=0; x < nums.length; x++) {
            int differece = target - nums[x];

            if (outPut.containsKey(differece)) {
                return new int[] {outPut.get(differece), x};
            }
           
           outPut.put(nums[x], x);
        }

        return new int[] {};
    }
}
