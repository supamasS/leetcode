class Solution {
    public boolean isHappy(int n) {
        int sum;
        Set<Integer> set = new HashSet<Integer>();
        
        while(n != 1) {
            int num = n;
            sum = 0;
            
            while(num > 0) {
                sum += (num%10)*(num%10);
                num /= 10;
            }
            
            if(sum != 1 && set.contains(sum))
                return false;
            
            set.add(sum);
            n = sum;
        }
        return true;
    }
}
