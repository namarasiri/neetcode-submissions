class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        int idx = 0;

        for (int right = 0; right < nums.length; right++) {

             // Remove indices outside window
            while (!dq.isEmpty() && dq.peekFirst() <= right - k) {

                dq.pollFirst();
            }

            // Remove smaller values
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]) {

                dq.pollLast();
            }

            // ADD CURRENT INDEX
            dq.offerLast(right);

            
            if (right >= k -1) {

                 result[idx++] = nums[dq.peekFirst()];

            }

        }
        
        
        return result;
    }
}
