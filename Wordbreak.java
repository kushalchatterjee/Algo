// Wordbreak problem.
//Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words. 
//Examples:
//Consider the following dictionary 
//{ i, like, sam, sung, samsung, mobile, ice, cream, icecream, man, go, mango}

//Input:  ilike
//Output: Yes 
//The string can be segmented as "i like".

//Input:  ilikesamsung
//Output: Yes
//The string can be segmented as "i like samsung" 
//or "i like sam sung".

public class Wordbreak {
    static String dictionary[] = {"mobile","samsung","sam","sung","man","mango","icecream","and","go","i","like","ice","cream"};
 
    public boolean dictionaryContains ( String s) {
        //int size = dictionary.length;
        int size = 13;
        for ( int i=0; i<size; i++) {
            //System.out.println (s+" "+dictionary[i]);
            if (dictionary[i].equals(s)  ) {
                return true;
            }
        }
        return false;
    }
 
    public boolean doWordBreak (String s) {
        int size = s.length();
        if ( size == 0 ) return true;
        // declare boolean array to track matches for broken prefixs, wb[i] would be true if s[0..i-1] has a match in dictionary
        boolean [] wb = new boolean[size+1]; 
        
        for ( int k=0; k<= size; k++) {
            wb[k] = false; // initalize 
        }
        
        for ( int i=1; i<= size; i++ ) {
            if ( wb[i] == false && dictionaryContains(s.substring(0,i) ) )
                wb[i] = true;
                
            if (wb[i] == true){
                if ( i== size) return true; // reched end of the string for prefix
                for ( int j=i+1; j <= size; j++ ) {
                    if ( wb[j]==false && dictionaryContains(s.substring(i,j) ) )
                        wb[j] = true;
                    if ( j==size && wb[j]== true)
                    return true;
                }
                
            }
            
        }
        
        //By now we've tried all prefixes and none worked
        return false;
        
        
    }
 
    /* Driver program to test above functions */
    public static void main(String args[]) {
        
        Wordbreak w = new Wordbreak();
        System.out.println ( "Match string 'ilikesamsung' with ditionary : " + w.doWordBreak("ilikesamsung") );
        
        System.out.println ( "Match string 'ilike' with ditionary : " + w.doWordBreak("ilike") );
        
        System.out.println ( "Match string 'ilikedont' with ditionary : " + w.doWordBreak("ilikedont") );
        
        System.out.println ( "Match string 'iiiiii' with ditionary : " + w.doWordBreak("iiiiii") );
        
    }
}
