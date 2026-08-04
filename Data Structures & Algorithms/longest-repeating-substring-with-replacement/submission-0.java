class Solution {
    public int characterReplacement(String s, int k) {
        

        HashMap<Character, Integer> m = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxF = 0;
        int res = 0;

        while(r < s.length()){
            char ch = s.charAt(r);
            m.put(ch, m.getOrDefault(ch, 0) + 1);
            maxF = Math.max(m.get(ch), maxF);
            if(r-l+1 - maxF <= k){
                res = r-l+1;
            }
            while(r-l+1 - maxF > k){
                char ch2 = s.charAt(l);
                m.put(ch2, m.get(ch2)-1);
                l++;
            }
            r++;
        }


        return res;
    }
}
