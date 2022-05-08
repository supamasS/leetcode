class Solution {
    public String largestOddNumber(String num) {        
        int oddIndex = num.length()-1;
        while((oddIndex >= 0) && (((num.charAt(oddIndex)-'0') & 1) == 0))
            oddIndex--;
        
        return (oddIndex < 0) ? "" : num.substring(0, oddIndex+1);
    }
}
