class Solution {
    public List<Integer> intersection(int[][] nums) {
        /*  input: 2-d array of int 
            output: list of int that are present in all nums[i]
            constraints:- can nums[i][j] be negative or 0? No, it's between 1,1000 inclusive
                        - can nums[i][j] be duplicate? No, they are unique
                        - can answer be an empty list? Yes
                        - result list must be in ascending order
                        - output is list or array? list
                        - could input be empty or contains an empty array? no, nums.length and nums[i].length is 1,1000 inclusive
                        - could nums[i] be different lengths? yes
                        - goal: optimize for runtime or memory? runtime - array, memory - hashmap, but need to sort keys
            Example: [[3,1,2,4,5],[1,2,3,4],[3,4,5,6]] -> [3,4]
                       ^     ^.        ^ ^   ^ ^
                       0 1 2 3 4 5 6
              count.  [0,2,2,3,3,2,1]
              list    [3,4]
              
                     [[1,2,3],[4,5,6]] -> []
                     
            Approach: store count in an array of values
            
            int[] count = new int[1001];    // value between 1,1000
            for(int i=0; i < nums.length; i++)
                for(int j=0; j < nums[i].length; j++)
                    count[nums[i][j]]++;
                    
            list = new ArrayList
            for(int c=0; c < count.length; c++)
                if(count[c] == nums.length)
                    list.add(c)
                    
            return list
        */
        
        int[] count = new int[1001];
        for(int i=0; i < nums.length; i++)
            for(int j=0; j < nums[i].length; j++)
                count[nums[i][j]]++;

        List<Integer> list = new ArrayList<>();
        for(int c=0; c < count.length; c++)
            if(count[c] == nums.length)
                list.add(c);

        return list;
    }
}
