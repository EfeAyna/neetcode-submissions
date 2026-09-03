class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int upBound = 0;
        int lowBound = 1;

        for(int i : piles){
            if (i > upBound){
                upBound = i;
            }
        }

        while(lowBound <= upBound){
            int mid = lowBound + (upBound - lowBound)/2;
            int t = 0;
            for(int i = 0; i < piles.length; i++){
                if(piles[i] % mid == 0){
                    t += piles[i] / mid;
                }
                else{
                    t += piles[i] / mid + 1;
                }
            }
            if(t > h){
                lowBound = mid+1;
            }
            else {
                upBound = mid-1;
            }
            
        }

        return lowBound;
    }
}
