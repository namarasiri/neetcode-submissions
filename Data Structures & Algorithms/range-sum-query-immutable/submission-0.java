class NumArray {

    private List<Integer> prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new ArrayList<>();
        int total = 0;

        for (int x : nums) {

            total += x;
            prefixSum.add(total);
        }
        
    }
    
    public int sumRange(int left, int right) {
        int preRight = prefixSum.get(right);
        int preLeft = left > 0 ? prefixSum.get(left -1) : 0;
        return (preRight - preLeft); 
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */