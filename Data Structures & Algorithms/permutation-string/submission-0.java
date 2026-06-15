class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Freq = new int[26];
        int[] winFreq = new int[26];

        int k = s1.length();
        int matches = 0;

        for (char c : s1.toCharArray()) {
            s1Freq[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] == winFreq[i]) {

                matches++;

            }
        }
        
        for (int right = 0; right < s2.length(); right++) {

            char rc = s2.charAt(right);
            winFreq[rc - 'a']++;

            if (winFreq[rc - 'a'] == s1Freq[rc - 'a']) {
                matches++;

            } else if (winFreq[rc - 'a'] == s1Freq[rc - 'a'] + 1) {
                matches--;

            }

            if (right >= k) {
            char old = s2.charAt(right - k);  // ← no left variable needed
            winFreq[old - 'a']--;
            if (winFreq[old - 'a'] == s1Freq[old - 'a'])     matches++;
            else if (winFreq[old - 'a'] == s1Freq[old - 'a'] - 1) matches--;
        }

        if (right >= k - 1 && matches == 26) return true;

        }

        return false;
    }
}
