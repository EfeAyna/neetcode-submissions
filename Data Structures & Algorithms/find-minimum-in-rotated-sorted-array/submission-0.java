class Solution {
    public int findMin(int[] nums) {
        if(nums[0] <= nums[nums.length-1]){
            return nums[0];
        }

        //if we here it is rotated for sure

        int left = 1;
        int right = nums.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid] < nums[mid-1]){
                return nums[mid];
            }
            else if(nums[mid] > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid-1;
            }
        }

        return left;
    }
}
