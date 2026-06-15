class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character, Integer> count = new HashMap<>();

        int maxFreq = 0;
        int left = 0;
        int answ = 0;

        for (int right =0; right < s.length(); right++) {

            char c = s.charAt(right);

            count.put(c, count.getOrDefault(c, 0) + 1);

            maxFreq = Math.max(maxFreq, count.get(c));

            while ((right - left + 1) - maxFreq > k) {

                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);

                left++;

            }

            answ = Math.max(answ, (right - left + 1));
        }

        return answ;
    }
}
