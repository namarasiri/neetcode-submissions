class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();

        for (char c : s.toCharArray()) {

            countMap.put(c, countMap.getOrDefault(c, 0) + 1);

        }

        for (char x : t.toCharArray()) {

            if (!countMap.containsKey(x)) {
                return false;
            }

            countMap.put(x, countMap.get(x) - 1);


            if (countMap.get(x) < 0) {
                return false;
            }
        }

        return true;
        
    }
}
