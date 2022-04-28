class Solution {
    public int minAddToMakeValid(String s) {
        /* 
            numOpen = 0
            count = 0
            loop over each char c of s
                if(c == ')')
                    if numOpen != 0
                        numOpen--
                    else
                        count++
                else    // '('
                    numOpen++
            
            count += numOpen
            
            return count
          
               i. 
       stack
       count   1
            "())"
             
               i
       stack (((
       count
            "((("
        */
        
        int numOpen = 0;
        int count = 0;
        
        for(char c : s.toCharArray()) {
            if(c == ')')
                if(numOpen == 0)
                    count++;
                else
                    numOpen--;
            else
                numOpen++;
        }
        
        count += numOpen;
        return count;
    }
}
