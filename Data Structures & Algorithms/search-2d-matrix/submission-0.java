class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length - 1;

        // if it fits in the very first row
        if (target <= matrix[0][n]) {
            return binarySearchRow(matrix[0], target);
        }

        
        //    matrix[left][n] < target <= matrix[right][n]
        int left = 0;
        int right = m - 1;

        // Target exceeds the entire matrix
        if (target > matrix[right][n]) return false;

        while (right - left > 1) {
            int mid = left + (right - left) / 2;

            if (matrix[mid][n] == target) {
                return true;
            } else if (matrix[mid][n] < target) {
                left = mid;   
            } else {
                right = mid;  
            }
        }

        
        return binarySearchRow(matrix[right], target);
    }

    private boolean binarySearchRow(int[] row, int target) {
        int l = 0;
        int r = row.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (row[mid] == target) return true;
            if (row[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}