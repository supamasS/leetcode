class Solution {
    public boolean backspaceCompare(String s, String t) {
        /*  Strings are lower case only, no need to do upper, lower
            No other special characters.
            If both are empty after backspacing, return true.
            Lengths are between 1,200 inclusive.
            No invalid input like "#a"
            Example:"ab#c", "ad#c" -> true
                    ^.      ^
                    "ab##", "c#d#" -> true
                       ^.      ^
                    "a#c", "b" -> false
                    "ab##cd", "aaacd" -> false
                    
            Approaches: 
            Brute force: build new strings by removing 1 previous character whenever # is seen
                         compare strings after backspacing
            Improved A:  2 pointers on each string, one for actual char, the other is for after backspacing - complicated to write logic.
            Improved B:  cs=0, ct=0
                         loop from the back, ps=s.length-1, pt=t.length-1

        */
        int skipS=0, skipT=0;
        
        for(int ps=s.length()-1, pt=t.length()-1; ps >= 0 || pt >=0; ps--, pt--) {
            // backspace for s
            for(; ps >= 0 && (s.charAt(ps)=='#' || skipS > 0); ps--) {
                if(s.charAt(ps) == '#')
                    skipS++;
                else
                    skipS--;
            }
            // backspace for t
            for(; pt >= 0 && (t.charAt(pt)=='#' || skipT > 0); pt--) {
                if(t.charAt(pt) == '#')
                    skipT++;
                else
                    skipT--;
            }     

            if(ps >= 0 && pt >= 0 && s.charAt(ps) != t.charAt(pt))
                return false;
            
            if((ps >=0 && pt < 0) || (ps < 0 && pt >= 0))
                return false;
        }
        return true;
    }
}
