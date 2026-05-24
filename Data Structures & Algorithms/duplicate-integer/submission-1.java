class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> dataMap = new HashMap<>();
        boolean hasDuplicates = false;

        for (int x : nums) {
            if (dataMap.containsKey(x)) {
                dataMap.put(x, dataMap.get(x) + 1);
                
            } else {
                dataMap.put(x, 1);
                
            }

        }

        return dataMap.entrySet().stream()
                                  .anyMatch(entry -> entry.getValue() > 1);
    }
}