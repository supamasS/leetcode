class Solution {
    public int trap(int[] height) {
        /* 
            example:
                                     lr
                         0 1 2 3 4 5 6 7 8 9 10
                height  [0,1,0,2,1,0,3,1,0,1,2]
                answer  [0,0,1,0,1,2,0,1,2,1,0]
                
                maxLeft 3 maxRight 2
                totalWater 1+1+2+1+2+1
            
                
                i = 0, maxLeft = 0, maxRight = 3, curWater = min(0,3) - 0 = 0
                i = 1, maxLeft = 0, maxRight = 3, curWater = min(0,3) - 1 = -1 -> 0
                i = 2, maxLeft = 1, maxRight = 3, curWater = min(1,3) - 0 = 1
                i = 3, maxLeft = 1, maxRight = 3, curWater = min(1,3) - 2 = -1 -> 0
                i = 4, maxLeft = 2, maxRight = 3, curWater = min(2,3) - 1 = 1
                i = 5, maxLeft = 2, maxRight = 3, curWater = min(2,3) - 0 = 2
                i = 6, maxLeft = 2, maxRight = 2, curWater = min(2,2) - 3 = -1 -> 0
                i = 7, maxLeft = 3, maxRight = 2, curWater = min(3,2) - 1 = 1
                i = 8, maxLeft = 3, maxRight = 2, curWater = min(3,2) - 0 = 0
                i = 9, maxLeft = 3, maxRight = 2, curWater = min(3,2) - 1 = 1
                i =10, maxLeft = 3, maxRight = 0, curWater = min(3,0) - 2 = -2 -> 0
                
                
                leftWall       6
                height[leftWall] = 3
                rightWall                   10
                                             
                water        1+1+2
                
            brute force:
                // runtime: O(n^2), space: O(1)
                scan for maxLeft and maxRight, calculate water in between
                totalWater = 0
                loop over height with i=0 to height.length-1
                    find maxLeft
                    find maxRight
                    curWater = min(maxLeft, maxRight) - height[i]
                    if(curWater > 0)
                        totalWater = totalWater + curWater
                return totalWater
        */
//         int totalWater = 0;
//         for(int i=0; i < height.length; i++) {
//             int maxLeft=0, maxRight=0;
            
//             for(int left=0; left < i; left++)
//                 maxLeft = Math.max(maxLeft, height[left]);
            
//             for(int right=i+1; right < height.length; right++)
//                 maxRight = Math.max(maxRight, height[right]);
            
//             int curWater = Math.min(maxLeft, maxRight) - height[i];
//             if(curWater > 0)
//                 totalWater += curWater;
//         }
//         return totalWater;
        
        /*
            improved:
                // accumulate water as we go based on left wall
                // DID NOT WORK because leftWall might be taller than rightWall
                water = 0
                find first non-zero element with next one lower, leftWall = that index
                find last non-zero element with previous one lower, rightWall = ending wall
                
                loop over height with i=leftWall+1 to rightWall
                    if(height[i] >= height[leftWall])
                        leftWall = i
                    else
                        h = height[leftWall] - height[i]
                        water += h
                    
                return water
        */
        
        // Solution from Udemy class
//         int totalWater = 0;
//         int maxLeft=0, maxRight=0;
        
//         for(int pl=0, pr=height.length-1; pl < pr; ) {
//             if(height[pl] <= height[pr]) {
//                 if(height[pl] <= maxLeft)
//                     totalWater += maxLeft - height[pl];
//                 else
//                     maxLeft = height[pl];
//                 pl++;
//             } else {
//                 if(height[pr] <= maxRight)
//                     totalWater += maxRight - height[pr];
//                 else
//                     maxRight = height[pr];
//                 pr--;
//             }
//         }
//         return totalWater;
        
        // My solution
        int totalWater = 0, curWater;
        int maxLeft=0, maxRight=0;
        
        for(int pl=0, pr=height.length-1; pl < pr; ) {
            if(height[pl] <= height[pr]) {
                curWater = maxLeft - height[pl];
                maxLeft = Math.max(maxLeft, height[pl]);
                pl++;
            } else {
                curWater = maxRight - height[pr];
                maxRight = Math.max(maxRight, height[pr]);
                pr--;
            }
            if(curWater > 0)
                totalWater += curWater;
        }
        return totalWater;
    }
}
