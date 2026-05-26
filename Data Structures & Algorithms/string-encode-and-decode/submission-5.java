class Solution {

    public String encode(List<String> strs) {

        if (strs == null || strs.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();


        for (String word : strs) {

            sb.append(word.length()).append("#").append(word);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        int start = 0;

        while (start < str.length()) {

            //find the separator #
            int end = start;
            while (str.charAt(end) != '#') {
                end++;

            }

            // Extract length
            int length = Integer.parseInt(str.substring(start, end));

            // Extract actual string
            end++; // move past '#'
            String s = str.substring(end, end + length);

            result.add(s);

            // Move to next encoded string
            start = end + length;

        }

        return result;
    }
}
