class Solution {
    public int maxArea(int[] height) {
        /*  example:
                [1,8,6,2,5,4,8,3,7] output: 7*7 = 49
                [1,1] output: 1*1 = 1
                [2,4,5,7,6,4,3,9] output: 7*4 = 28
                [7,1,2,3,9] output: 7*4 = 28
                [] or [2] output: 0
                [6,9,3,4,5,8] output: 8*4 = 32
            
            
        */
        
        // brute force: for each pair of values, calculate area and find max area
        // runtime: O(n^2) space: O(1)
        // Time Limit Exceeded
//         int maxA = 0;
//         for(int left=0; left < height.length; left++) {
//             for(int right=left+1; right < height.length; right++) {
//                 int h = Math.min(height[left], height[right]);
//                 int w = right-left;
//                 int area = h * w;
//                 maxA = Math.max(maxA, area);
//             }
//         }
        
//         return maxA;
        
        // use 2 pointers
        // runtime: O(n) space: O(1)
        int maxA = 0;
        for(int left=0, right=height.length-1; left < right; ) {
            int h = Math.min(height[left], height[right]);
            int w = right-left;
            int area = h * w;
            maxA = Math.max(maxA, area); 
            if(height[left] <= height[right])
                left++;
            else
                right--;
        }
        return maxA;
    }
}
