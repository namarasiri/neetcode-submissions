class Solution {
    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int max = 0;

        Map<Character, Integer> seen = new HashMap<>();

        for (int right =0; right < s.length(); right++) {

            char c = s.charAt(right);

            if (seen.containsKey(c) && seen.get(c) >= left) {

               left = seen.get(c) + 1;

            }

            seen.put(c, right);

            max = Math.max(max, right - left + 1);

        }


        return max;
    }
}
