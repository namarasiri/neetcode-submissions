class Solution {
    public boolean isValid(String s) {

        if (s.length() == 0) {

            return false;

        }

        Stack<Character> keep = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                keep.push(c);
            } else {

                if (keep.isEmpty()) {
                    return false;

                }

                char top = keep.pop();

                if (c == ')' && top != '(') {
                    return false;

                }

                 if (c == ']' && top != '[') {
                    return false;

                }

                 if (c == '}' && top != '{') {
                    return false;

                }

            }
        }
        
        return keep.isEmpty();
    }
}
