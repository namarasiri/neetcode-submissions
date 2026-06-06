class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

       

        for (int row =0; row < matrix.length; row++) {

            

            if (found(matrix[row], target) != -1) {

                return true;

            }

        }
        
        return false;
    }

    public int found(int num[], int target) {

         int mid = 0;
         int left = 0, right = num.length -1;

         while (left <= right) {

            mid = (left + right) / 2;

            if (target > num[mid]) {

                left = mid + 1;

            } else if (target < num[mid]) {

                right = mid - 1;

            } else {

                return mid;

            }

         }

        return -1;
    }

}
