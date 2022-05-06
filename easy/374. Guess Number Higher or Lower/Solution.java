/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return (int)checkNumber(1, n);
    }
    
    private long checkNumber(long min, long max) {
        if(min > max)   // should never reach here, but just in case
            return 0;
        
        int mid = (int)((min+max)/2);
        
        if(guess(mid) == 0)
            return mid;
        else if(guess(mid) == -1)
            return checkNumber(min, mid-1);
        else
            return checkNumber(mid+1, max);
    }
}
