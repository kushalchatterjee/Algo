//Given a string s, find the longest palindromic substring in s. 

//Example :
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//Example:

//Input: "cbbd"
//Output: "bb"

//Note : This code attempts to find a solution without using extra storage. It inspects the string towards left and towards right of the center. 

public class Solution{
    
    public String findlongestPalindrome(String s1) { 
  
      int len=s1.length();
      int median = s1.length()/2;
      
      int i, j;
      
      if ( (len % 2 ) != 0 ) // length is odd
      {
        i= median; j=median;
        while (i> 0 && j< len-1)
        {
          
          if ( s1.charAt(i-1) != s1.charAt(j+1) ) {
              
            break;
            
            }
          else {
            i--; j++;
          }
          
        }
        if (i==median && j==median) // Not a palindrome
        {
            System.out.println("Not Palindrome");
            return null;
        }
      }    
      else //length is even
      {
        i= median-1; j=median;
        while (i> 0 && j< len-1)
        {
            
          if ( s1.charAt(i) != s1.charAt(j) ) {
                break;
            }
          else {
            i--; j++;
          }
        }
        if (i== median-1 && j==median) // Not a palindrome
        {
            System.out.println ( "Not a Palindrome");
            return null;
        }
      }
      
      return s1.substring (i,j+1);
    }

     public static void main(String []args) {
        
        Solution s = new Solution();
        
        
        System.out.println ( "Longest Palindrome : " + s.findlongestPalindrome("edabccbade") );
        System.out.println ( "Longest Palindrome : " + s.findlongestPalindrome("zyxyz") );
        System.out.println ( "Longest Palindrome : " + s.findlongestPalindrome("abcde") );
        System.out.println ( "Longest Palindrome : " + s.findlongestPalindrome("abcdef") );
        System.out.println ( "Longest Palindrome : " + s.findlongestPalindrome("abcdefgh") );
        
     }
}
