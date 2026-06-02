class Solution {
    public int trap(int[] height) {

        int left = 0, right = height.length -1;
        int leftMax = 0;
        int rightmax = 0;
        int waterTrapped = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                leftMax = Math.max(leftMax, height[left]);

                waterTrapped += leftMax - height[left];

            left++; 

            } else {

                rightmax = Math.max(rightmax, height[right]);

                waterTrapped += rightmax - height[right];

                right--;

            } 

        }
        
        return waterTrapped;
    }
}
