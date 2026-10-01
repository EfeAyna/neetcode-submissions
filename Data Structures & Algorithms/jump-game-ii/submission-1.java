class Solution {
    public int jump(int[] nums) {
        int res = 0, reach = 0, curEnd = 0;

        if(nums.length < 2){
            return 0;
        }

        for(int i = 0; i < nums.length; i++){
            reach = Math.max(reach, i + nums[i]);
            if(curEnd == i){
                res++;
                curEnd = reach;
            }

            if(curEnd >= nums.length-1){
                break;
            }
        }

        return res;
        
    }
}
