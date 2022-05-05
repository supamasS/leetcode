class Solution {
    public int bitwiseComplement(int n) {
        // find how many bits there are, then subtract from 2^b-1
        if(n == 0)
            return 1;
        
        int val = n;
        int powOfTwo = 1;
        
        while(val > 0) {
            powOfTwo <<= 1;
            val >>= 1;
        }
        
        return powOfTwo-1-n;
    }
}
