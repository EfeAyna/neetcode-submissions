

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[k];

        List<List<Integer>> ls = new ArrayList<>();

        for(int i = 0; i<= nums.length; i++){
            ls.add(new ArrayList<>());
        }

        for(int key : m.keySet()){
            ls.get(m.get(key)).add(key);
        }

        int counter = 0;
        for(int i = nums.length; i > 0 && counter != k ; i--){
            List<Integer> l = ls.get(i);
            for(int num : l){
                res[counter] = num;
                counter++;
                if(counter == k){
                    break;
                }
            }
        }

        return res;

    }
}