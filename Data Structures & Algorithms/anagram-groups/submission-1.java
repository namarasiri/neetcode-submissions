class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> outPut = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];

            for (char c : s.toCharArray()) {

                count[c - 'a']++;

            }

            String key = Arrays.toString(count);
            outPut.putIfAbsent(key, new ArrayList<>());
            outPut.get(key).add(s);
        }

        return new ArrayList<>(outPut.values());
        
    }
}
