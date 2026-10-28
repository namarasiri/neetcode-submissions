class Solution {


    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        if (k== 0 || nums.length == 0) return -1;

        for (int num : nums) {

            heap.offer(num);

            if (heap.size() > k) {

                heap.poll();

            }

        }

return heap.peek();
        
    }
}
