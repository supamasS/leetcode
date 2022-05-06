class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    
    private int binarySearch(int[] nums, int target, int min, int max) {
        // base case
        if(min > max)
            return -1;
        
        int mid = (min+max)/2;
        
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] < target) 
            return binarySearch(nums, target, mid+1, max);
        else
            return binarySearch(nums, target, min, mid-1);
            
    }
}
