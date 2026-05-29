class Solution {
    public boolean isPalindrome(String s) {

        // Convert a string to an array of lower case characters (without spaces)
        char[] chars = s.replaceAll("[^a-zA-Z0-9]", "")
                          .toLowerCase()
                          .toCharArray();

        int left = 0, right = chars.length -1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
        
    }
}
