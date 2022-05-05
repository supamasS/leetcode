class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        // 1 + n+1 + 2n+1 + 3n+1 + 4n +1 ...
        // n(m/2(m+1)) + m + 1
        // (m+1)(nm + 2) = 2*candies
        
        // candies = 10, num_people = 3
        // 1,2,3 -> 3(3+1)/2 = 6 , 10 -> can give more to first person
        // 4,5,6 -> 3*(4+6)/2 = 15
        // 7,8,9
        // n(n+1) <= 2*candies
        // Logic got too complicated and did simple, straightforward algorithm instead.
        
        int[] distribution = new int[num_people];
        int count = 0;
        
        for(int i=0; candies > 0; ) {
            count = (count < candies) ? count+1 : candies;
                        
            distribution[i] += count;
            candies -= count;

            i = (i == num_people-1) ? 0 : i+1;
        }
        
        return distribution;
    }
}
