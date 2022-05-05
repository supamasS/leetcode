class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] divided = new String[(s.length()+k-1)/k];
        
        char[] substr = new char[k];
        
        for(int i=0, m=0; i < s.length(); m++) {
            for(int j=0; j < k; j++, i++) {
                substr[j] = (i < s.length()) ? s.charAt(i) : fill;
            }
            divided[m] = new String(substr);
        }
        
        return divided;
    }
}
