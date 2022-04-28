class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        /*
            counts = an array of int, size 101
            iterate over nums
                do radix sort
                also collecting the totalSum of all elements
                
            sum = 0
            create an empty list
            iterate over counts from the last index to the beginning
                if(counts[i] != 0)
                    add i to the list
                    counts[i]--;
                    
                    collect sum from each i value
                
                    if sum > totalSum - sum
                        return list
                    
                if(counts[i] == 0)
                    i--
                    
            return list // should never get here
        */
        
        int[] counts = new int[101];
        int totalSum = 0;
        
        for(int num : nums) {
            counts[num]++;
            totalSum += num;
        }
        
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        
        for(int i=counts.length-1; i >= 0; ) {
            if(counts[i] != 0) {
                list.add(i);
                counts[i]--;
            
                sum += i;

                if(sum > totalSum - sum)
                    return list;
            } 
            
            if(counts[i] == 0)
                i--;
        }
        
        return list;    // should never get here
    }
}
