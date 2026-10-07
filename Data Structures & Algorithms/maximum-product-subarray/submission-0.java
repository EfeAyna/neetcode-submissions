class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = 1, curMin = 1;

        for (int x : nums) {
            if (x < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(x, curMax * x);
            curMin = Math.min(x, curMin * x);

            res = Math.max(res, curMax);
        }

        return res;
    }
}