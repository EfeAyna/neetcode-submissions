class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] res = new int[2];

        for(int i = 0; i < nums.length; i++){
            if(m.containsKey(nums[i])){
                res[0] = m.get(nums[i]);
                res[1] = i;
                break;
            }
            m.put(target - nums[i], i);
        }
        return res;
    }
}
