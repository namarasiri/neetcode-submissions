class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = maxPile(piles);

        int hours = right;
        
        while (left <= right) {

            int mid = left + (right - left) /2;

            if (canEatAll(piles, h, mid)) {
                hours = mid;
                right = mid - 1;

            } else {
                left = mid + 1;
            }

        }
        
        return hours;
    }

    public int maxPile(int[] piles) {

        int max = 0;

        for (int pile : piles) {

            max = Math.max(max, pile);

        }

        return max;

    }

    private boolean canEatAll(int[] piles, int h, int k) {

        long hours = 0;

        for (int pile : piles) {

            hours += (pile + k - 1) / k; // ceil(pile / k)

            if (hours > h) {
                return false; // too slow, stop early
            }
        }

        return hours <= h;
    }
}
