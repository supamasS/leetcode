class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        // 01/01/1971 was Friday
        
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] daysInWeek = { "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        
        int days = (year-1971) * 365;
        days += (year-1968-1)/4;  // add 1 for each leap year before this year, 1968 is previous leap year
        
        for(int i=0; i < month-1; i++)
            days += daysInMonth[i];
        
        if(isLeapYear(year) && month > 2)    // current year is leap year
            days++;
        
        days += (day-1);
        
        return daysInWeek[days%7];
    }
    
    private boolean isLeapYear(int year) {
        if(year%4 == 0) {
            if(year%100 == 0) {
                if(year%400 == 0) {
                    return true;
                } else
                    return false;
            } else
                return true;
        } else
            return false;
    }
}
