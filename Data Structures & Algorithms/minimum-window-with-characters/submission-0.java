class Solution {
    public String minWindow(String s, String t) {

        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> needFreq = new HashMap<>();
        Map<Character, Integer> currentFreq = new HashMap<>();
        
        

        for (char c : t.toCharArray()) {
            needFreq.put(c, needFreq.getOrDefault(c, 0) + 1);
        }

        int required = needFreq.size(); // unique chars needed
        int formed = 0;             // unique chars satisfied

        int left = 0;

        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right ++) {

            char rc = s.charAt(right);
            currentFreq.put(rc, currentFreq.getOrDefault(rc, 0) + 1);

           if (needFreq.containsKey(rc) && currentFreq.get(rc).intValue() == needFreq.get(rc).intValue()) {

            formed++;

           }

           while (formed == required) {

            int windowLen = right - left + 1;

            if (windowLen < minLen) {
                    minLen = windowLen;
                    startIndex = left;
            }

             char lc = s.charAt(left);

             currentFreq.put(lc, currentFreq.getOrDefault(lc, 0) - 1);

              if (needFreq.containsKey(lc)
                        && currentFreq.get(lc) < needFreq.get(lc)) {

                    formed--;
                }

                left++;


           }

        }
        
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }
}
