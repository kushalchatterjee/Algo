//Given a string, find the length of the longest substring without repeating characters.
//Examples:
//Given "abcabcbb", the answer is "abc", which the length is 3.
//Given "bbbbb", the answer is "b", with the length of 1.
//Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


import java.util.*;

public class Solution{
    
    
    public int lengthOfLongestSubstring(String s) {
        int i=0, len=0, tempLength=0;
        
        System.out.println ("lenght:"+ s.length());
        
        for ( i=0, tempLength=1 ; i<s.length()-1; i++, tempLength++)
        {
            //System.out.println ("i:"+i+ " tempLenght:"+tempLength+" len:"+len);
            if (s.charAt(i) == s.charAt(i+1) ) {
                len=tempLength;
                tempLength=0;
            } 
           
            if (tempLength > len)
                    len=tempLength;
            
            
        }
        
        if (tempLength > len)
                    len=tempLength;
        return len;
        
    }
    

        public static void main (String [] args) {
            
            String str1 = "abccde";
            String str2 = "efgh";
            String str3 = "pqrstuvwxyzz";
            String str4 = "pwwwkebww";
            
            Solution s = new Solution();
            System.out.println (s.lengthOfLongestSubstring(str1));
            System.out.println (s.lengthOfLongestSubstring(str2));
            System.out.println (s.lengthOfLongestSubstring(str3));
            System.out.println (s.lengthOfLongestSubstring(str4));
        
       
        
    }

    
}
