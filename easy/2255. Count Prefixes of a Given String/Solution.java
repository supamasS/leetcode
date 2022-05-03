class Solution {
    public int countPrefixes(String[] words, String s) {
        /*
            input:  words = array of strings - lower case letters
                    s = string - lower case letters
                    both can be empty? no!
                    string length between 1,10 inclusive
                    words array length between 1,1000 inclusive
                    if words[i] == s, count as prefix
            output: count of words that are prefix of s
            Example:words = ["a","b","c","ab","bc","abc"], s = "abc" -> 3
                              ^           ^^        ^^^
                    words = ["a","a"], s = "aa" -> 2
                    duplicate words[i] counted twice -> potential optimization
                    
            Brute force: loop over words, check if words[i] is prefix of s, increase count
                         O(n*m) where n=words.length, m=words[i].length
            Improved #1: Once each words[i] is checked, store whether it's a prefix in a hash map
            Improved #2: Since s.length is small, but words.length is large, store all possible prefixes in a set first, then check if each words[i] is in the set.
            
            count = 0
            prefixMap = empty hash map with boolean value
            loop over words with i=0 to words.length-1
                if(words[i] is not in prefixMap)
                    map.put(words[i], isPrefix(words[i], s))
                    
                if(prefixMap.get(words[i]))
                    count++
            return count
            
            boolean isPrefix(word, s)
                if word is longer than s
                    return false
                    
                loop over word with j=0 to word.length-1
                    if(word.charAt(j) != s.charAt(j))
                        return false
                return true
        */
        
        // version 1 - 4 ms
//         int count=0;
//         Map<String, Boolean> prefixMap = new HashMap<>();
//         for(String word : words) {
//             if(!prefixMap.containsKey(word))
//                 prefixMap.put(word, isPrefix(word, s));
            
//             if(prefixMap.get(word))
//                 count++;
//         }
//         return count;
        
        // version 2 - 2 ms
        // int count=0;
        // for(String word : words) {
        //     if(isPrefix(word, s))
        //         count++;
        // }
        // return count;
        
        // version 3 - store all prefixes first
//         Set<String> prefixes = new HashSet<>();
//         StringBuilder sb = new StringBuilder();
//         for(char c : s.toCharArray()) {
//             sb.append(c);
//             prefixes.add(sb.toString());
//         }
        
//         int count=0;
//         for(String word : words) {
//             if(prefixes.contains(word))
//                 count++;
//         }
//         return count;
        
        // version 4 - use .startsWith method
        int count = 0;
        
        for(String word : words)
            if(s.startsWith(word))
                count++;
        
        return count;
    }
    
//     private boolean isPrefix(String word, String s) {
//         if(word.length() > s.length())
//             return false;
        
//         for(int j=0; j < word.length(); j++)
//             if(word.charAt(j) != s.charAt(j))
//                 return false;
//         return true;
//     }
    
}
