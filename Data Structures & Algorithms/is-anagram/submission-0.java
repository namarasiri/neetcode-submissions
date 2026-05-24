class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        // Map to store character counts
        Map<Character, Integer> countMap = new HashMap<>();
        
        // Count characters from s
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        // Subtract counts using characters from t
        for (char c : t.toCharArray()) {
            if (!countMap.containsKey(c)) {
                return false; // char not in s
            }
            countMap.put(c, countMap.get(c) - 1);
            if (countMap.get(c) < 0) {
                return false; // more occurrences in t than in s
            }
        }
        
        return true;

        
    }
}
