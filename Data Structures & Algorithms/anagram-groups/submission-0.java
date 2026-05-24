class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // Map to hold sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {

            // Convert to char array, sort, and turn back to string
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);

            // Put into map
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(map.values());
    }
}
