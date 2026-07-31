class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for(String s : strs){
            int[] code = new int[26];
            for(char c : s.toCharArray()){
                code[c - 'a']++;
            }

            String key = Arrays.toString(code);

            m.computeIfAbsent(key, filler -> new ArrayList<>()).add(s);

        }

        return new ArrayList<>(m.values());
    }
}
