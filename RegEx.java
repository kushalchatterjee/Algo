//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.

//The matching should cover the entire input string (not partial).

public class RegEx{
    
    public RegEx () {
        
    }
    
    public boolean isMatch (String s1, String s2) {
        int size1 = s1.length();
        int size2 = s2.length();
        boolean result [][] = new boolean [size1+1][size2+1];
        
    
            
        result[0][0]=true;
        
        for ( int j=1; j< size2; j++)
        if ( s2.charAt(j-1) == '*' )
            result [0][j] = result[0][j-1];
            
        for ( int i=1; i<=size1; i++)
            for (int j=1; j<=size2 ; j++) {
                
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                
                if (s2.charAt(j-1) =='*')
                    result[i][j] = result[i][j - 1] ||
                                   result[i - 1][j];
            
                
                else if (s2.charAt(j-1)=='.' || s2.charAt(j-1) == s1.charAt(i-1) )
                    result[i][j] = result [i-1][j-1];
                else 
                    result[i][j] = false;
            }
        
        return result[size1][size2];
        
    }

     public static void main(String []args){
        boolean match;
        System.out.println("Hello World");
        RegEx r = new RegEx();
        match=r.isMatch ("aa","a");
        System.out.println("Is a match ?" + match);
        
        
        match=r.isMatch ("aa","a*");
        System.out.println("Is a match ?" + match);
     }
}
