class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int l = 0;
        int r = s1.length()-1; // inclusive
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        for(char c : s1.toCharArray()){
            arr1[c - 'a']++;
        }
        for(int i = 0; i <= r; i++){
            arr2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (Arrays.equals(arr1, arr2)) return true;
            
            // Remove the leftmost char of current window, add the next char
            arr2[s2.charAt(i) - 'a']--;
            arr2[s2.charAt(i + s1.length()) - 'a']++;
        }

        
        return Arrays.equals(arr1, arr2);
    }
}
