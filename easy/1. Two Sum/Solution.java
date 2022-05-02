class Solution {
    public int[] twoSum1(int[] nums, int target) {
        // brute force
        // runtime: O(n^2), space: O(1)

        // already taken care of by the for loop
        // if(nums.length < 2)
        //     return null;
        
        for(int i=0; i < nums.length-1; i++) {
            int numToFind = target-nums[i];
            for(int j=i+1; j < nums.length; j++) {
                if(nums[j] == numToFind) {
                    return new int[]{i, j};
                }
            }
        }
        
        return null;
    }
    
    // nums = [2,7,11,15], target = 9
    // map = {7:0}
    
    // nums = [3,2,4], target = 6
    // map = {(3:0, 4:1}
    
    // nums = [3,3], target = 6
    // map = {3:0}
    public int[] twoSum(int[] nums, int target) {
        // Hash map
        // run time = O(n), space = O(n)
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i < nums.length; i++) { 
            Integer matchedIndex = map.get(nums[i]);
            if(matchedIndex == null) { 
                int numToFind = target-nums[i];
                map.put(numToFind, i);                
            } else {
                return new int[] { matchedIndex, i };
            }
        }
        
        return null;
    }
}
