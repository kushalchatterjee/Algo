import java.util.*;

public class Solution{
    public ArrayList <Integer> arr;
    Solution (){
        arr = new ArrayList <Integer> ();
    }
    
    public void sort (){
        int len = arr.size();
        
        for ( int i=1; i< len; i++){
            int j, key;
            j=i-1;
            key = (int)arr.get(i);
            
            while ( (j >=0) && (key < (int)arr.get(j)) ) {
               arr.set(j+1, arr.get(j));
               j=j-1;
            }
            arr.set(j+1,key);
        }
        
    }
    
    public void print_list(){
        for ( int k=0; k< arr.size(); k++) 
        System.out.println ("Value :" + arr.get(k));
    }
    
     public static void main(String []args){
        
        Solution s = new Solution ();
        s.arr.add(11);
        s.arr.add(4);
        s.arr.add(6);
        s.arr.add(81);
        s.arr.add(35);
        s.arr.add(95);
        s.arr.add(5);
        s.print_list();
        s.sort();
        System.out.println ("Printing after sort");
        s.print_list();
        
        
     }
}
