class Solution {
    public boolean hasDuplicate(int[] nums) {

        Map<Integer, Integer> dataMap = new HashMap<>();

        for (Integer num : nums) {

            if (dataMap.containsKey(num)) {

                dataMap.put(num, dataMap.get(num) + 1);

            } else {
                dataMap.put(num, 1);

            }

        }

        return dataMap.entrySet().stream()
                                  .anyMatch(entry -> entry.getValue() > 1);
    }
}