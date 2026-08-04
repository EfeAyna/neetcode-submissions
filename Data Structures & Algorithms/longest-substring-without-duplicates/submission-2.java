class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map = new HashMap<>();
        int startIndex = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            
            if (map.containsKey(ch) && map.get(ch) >= startIndex) {
                startIndex = map.get(ch) + 1;
            }

            map.put(ch, i);
            
            res = Math.max(res, i - startIndex + 1);
        }

        return Math.max(res, s.length() - 1 - startIndex);
    }
}
