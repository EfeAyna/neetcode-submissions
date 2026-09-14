class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int num : nums){
            if(pq.size() < k){
                pq.add(num);
                continue;   
            }
            if(num > pq.peek()){
                pq.add(num);
                pq.poll();
            }
            
        }
        return pq.peek();
    }
}
