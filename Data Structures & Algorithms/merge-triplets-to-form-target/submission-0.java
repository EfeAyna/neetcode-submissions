class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        
        int[] cur = new int[3];
        for(int[] triplet : triplets){
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                cur[0] = Math.max(triplet[0] , cur[0]);
                cur[1] = Math.max(triplet[1], cur[1]);
                cur[2] = Math.max(triplet[2], cur[2]);
            }
        }
        return (cur[0] == target[0] && cur[1] == target[1] && cur[2] == target[2]);
    }
}
