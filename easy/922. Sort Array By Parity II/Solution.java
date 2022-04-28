class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        /*
            even=0, odd=1
            loop through nums
                if(nums[even] is odd)
                    if(nums[odd] is even)
                        swap nums[even] and nums[odd]
                        even = even+2
                    odd = odd+2
                else
                    even = even+2
                
            return nums
            
                     e
                   o
            [4,2,5,7]
            [4,5,2,7]
        */
        
        for(int even=0, odd=1; even < nums.length && odd < nums.length; ) {
            if(nums[even]%2 == 1) {
                if(nums[odd]%2 == 0) {
                    int tmp = nums[odd];
                    nums[odd] = nums[even];
                    nums[even] = tmp;
                    even += 2;
                } 
                odd += 2;
            } else
                even += 2;
        }
        
        return nums;
    }
}
