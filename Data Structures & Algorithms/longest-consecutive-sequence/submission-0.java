class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {

            set.add(num);

        }

        int longest = 0;

        // Check every number
        for (int num : set) {

            // Only start if this is the beginning
            if (!set.contains(num -1)) {
                int currentNum = num;
                int currentLength = 1;

                // Keep going while next number exists
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                longest = Math.max(longest, currentLength);
            }
        }
        
        return longest;
    }
}
