class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = 1001;
        for(int i : hand){
            map.put(i, map.getOrDefault(i , 0) + 1);
            min = Math.min(i , min);
        }
        int count = 0;
        while(count < hand.length){
            while(map.getOrDefault(min, 0) == 0){
                min++;
            }
            int cur = min;
            for(int i = 0; i < groupSize-1; i++){
                map.put(cur, map.get(cur)-1);
                if(map.getOrDefault(cur+1,0) == 0){
                    return false;
                }
                cur++;
            }
            map.put(cur, map.get(cur)-1);
            count += groupSize;
            
        }
        return true;
        
        

    }
}
