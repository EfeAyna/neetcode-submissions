class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length-1;
        int area = 0;
        while(i<j){
            area = Math.max(area, (j-i)*Math.min(heights[i], heights[j]));
            if(heights[i] > heights[j]){
                j--;
            }
            else if(heights[i] < heights[j]){
                i++;
            }
            else{
                i++;
            }
        }
        return area;
    }
}
