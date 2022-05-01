class Solution {
    public int[] sortEvenOdd(int[] nums) {
        /*
            input: nums - array of int
            output: array of int with
                    - odd indices sorted non-increasing - descending
                    - even indices sorted non-decreasing - ascending
                    
            Example: [4,1,2,3] -> [2,3,4,1]
                     [2,1] -> [2,1]
                     [4,3,5,2,6,7,5] -> [4,7,5,3,5,2,6]
                     
            Questions: - is nums.length even only? no, since it's 1 to 100
                       - what's the size of nums? 1,100 inclusive
                       - what are values in nums[i]? int between 1,100 inclusive
                    
            Quick brute force: create 2 arrays, one for odd and one for even, sort them, then put them back in the answer array - O(nlgn) for sorting
            
            Improvement: since input nums[i] is between 1 and 100 inclusive - small range, use counting sort on even and on odd indices separately.
            
            * what if nums.length is odd - okay
            
            create 2 arrays, oddIndex and evenIndex, with size = 101
            
            iterate over nums with i starting at 0, increment by 1
                if(i is even)
                    // even index
                    increment evenIndex at nums[i] position
                else
                    // odd index
                    increment oddIndex at nums[i] position
                    
            // iterate over oddIndex and evenIndex and put values back to nums in the given order 
            even = 0
            odd = oddIndex.length-1
            
            for loop over nums with i starting at 0, increment by 1
                if(i is even)
                    // even
                    while(evenIndex[even] == 0)
                        even++
                    nums[i] = even
                    evenIndex[even]--
                else
                    // odd
                    while(oddIndex[odd] == 0)
                        odd--
                    nums[i] = odd
                    oddIndex[odd]--
                
            return nums
            
             nums   [4,1,2,3]  
          evenIndex [0,0,0,0,0]
          oddIndex. [0,1,0,0,0]
          
          even.      4
          odd        1
          i                3
          nums      [2,3,4,1]
        */
        
        // could also find min and max values for even / odd index and allocate just enough memory spaces
        int[] evenIndex = new int[101];
        int[] oddIndex = new int[101];
        
        // counting sort
        for(int i=0; i < nums.length; i++) {
            if((i & 1) == 0)
                evenIndex[nums[i]]++;
            else
                oddIndex[nums[i]]++;
        }
        
        // put values back in specified order
        for(int i=0, even=0, odd=oddIndex.length-1; i < nums.length; i++) {
            if((i & 1) == 0){
                while(evenIndex[even] == 0)
                    even++;
                nums[i] = even;
                evenIndex[even]--;
            } else{
                while(oddIndex[odd] == 0)
                    odd--;
                nums[i] = odd;
                oddIndex[odd]--;
            }
        }
        
        return nums;
    }
}
