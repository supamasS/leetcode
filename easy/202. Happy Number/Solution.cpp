class Solution {
public:
    set<int> seen;
    // version 1 - 4 ms recursive
//     bool isHappy(int n) {
//         int sum=0, i;
//         while(n > 0) {
//             i = n%10;
//             sum += i*i;
//             n /= 10;
//         }
        
//         if(sum == 1)
//             return true;
//         else if(seen.count(sum))
//             return false;
//         else {
//             seen.insert(sum);
//             return isHappy(sum);
//         }
//     }
    
    // version 2 - 0 ms
    bool isHappy(int n) {
        int sum, i;
        
        while(n != 1) {
            sum = 0;
            
            while(n > 0) {
                i = n%10;
                sum += i*i;
                n /= 10;
            }

            if(sum != 1 && seen.count(sum))
                return false;
            
            seen.insert(sum);
            n = sum;
        }
        return true;
    }
};
