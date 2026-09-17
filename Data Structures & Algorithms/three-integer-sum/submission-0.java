class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.addAll(twoSum(nums , 0, -nums[0]));
        for(int i = 1; i < nums.length-2; i++){
            if(nums[i-1] != nums[i]){
                res.addAll(twoSum(nums, i, -nums[i]));
            }
        }

        return res;
    }


    public List<List<Integer>> twoSum(int[] nums, int index, int target){
List<List<Integer>> subRes = new ArrayList<>();
    int left = index + 1;
    int right = nums.length - 1;

    while (left < right) {
        int sum = nums[left] + nums[right];

        if (sum < target) {
            left++;
        } else if (sum > target) {
            right--;
        } else {
            subRes.add(List.of(-target, nums[left], nums[right]));

            
            while (left < right && nums[left] == nums[left + 1]) {
                left++;
            }
            
            while (left < right && nums[right] == nums[right - 1]) {
                right--;
            }

            left++;
            right--;
        }
    }
    return subRes;
    }
}
