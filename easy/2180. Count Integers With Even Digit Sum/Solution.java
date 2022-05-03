class Solution {
    public int countEven(int num) {
        /*  input: positive int between 1,1000 inclusive, no negative
            output: count of # of even digit numbers <= num
            Example:
            37 =        2,    4,   6,   8, 
                     11,  13,  15,  17,  19, odd row starts at 1
                  20,   22,  24,  26,  28,   even row starts at 0, except first row
                     31,  33,  35,  37
                     
            29 =        2, 4, 6, 8, 
                     11, 13, 15, 17, 19, 1->1, 2->1, 3->2, 4->2, 5->3
                     20, 22, 24, 26, 28. 0->1, 1->1, 2->2, 3->2, 4->3, 8->5, 9->5
            
            115 =       2,    4, ... , 
                                         99, 
                     101, 103, 105, 107, 109,
                  110,  112, 114
                     
            Brute force: iterate over each number, add digits, then if it's even, add to count - runtime: O(n*m) where n=num, m=number of digits
            Approach: use pattern, treat even and odd row a little differently
            
            rowNum = num/10
            if(rowNum == 0)
                return num/2
                
            count = 4 + (rowNum-1)*5
            remainder = num%10
            
            if(isDigitSumOdd(rowNum))
                count += (remainder+1)/2
            else
                count += remainder/2+1
                
            return count
                
            boolean isDigitSumOdd(int rowNum)
                digitSum = 0
                while(rowNum > 0)
                    digitSum += rowNum % 10
                    rowNum /= 10
                return digitSum & 1 == 1
        */
        int rowNum = num/10;

        // not needed since it's included in the below condition
        // if(rowNum == 0)
        //     return num/2;  
        
        int count = 4 + (rowNum-1)*5;
        int remainder = num%10;
        
        count += isDigitSumOdd(rowNum) ? (remainder+1)/2 : remainder/2+1;
        
        return count;
    }
    
    private boolean isDigitSumOdd(int rowNum) {
        int digitSum = 0;
        while(rowNum > 0) {
            digitSum += rowNum % 10;
            rowNum /= 10;
        }
        return (digitSum & 1) == 1;
    }
}
