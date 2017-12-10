import java.util.*;

public class CountSort{
    public ArrayList <Integer> arr;
    public CountSort (){
        arr = new ArrayList <Integer> ();
    }
    
    public void sort (ArrayList <Integer> arr){
        int n = arr.size();
        int len = find_max(arr);
        int count [] = new int[len+1];
        int [] output = new int[n];
        
        System.out.println ("Before count. Max is :" + len);
        
        for (int i = 0; i <= len ; i++)
            count [i] = 0;
        
        // Build count array, count number of times the value occurs
        for (int i = 0; i < n ; i++) {
            if ( arr.get(i) <= len) {
                System.out.println ("i "+i + ", arr.get(i)" + arr.get(i));
                count[arr.get(i)]++;
            }
        }
        
        // Update count array so that count [] now hodls the position of values in output
        for (int i = 1; i < len ; i++) {
            count[i] += count[i-1];
        }
        
        //place the values in output array now
        for (int i = 0; i < n ; i++) {
            System.out.println ("count " + count[arr.get(i)-1]+ " arr[i]"+  arr.get(i));
            output[count[arr.get(i)-1] ] = arr.get(i);
            --count[arr.get(i)];
        }
        
        for (int i = 0; i < n ; i++) {
            System.out.println ("output :" + output[i] );
        }
        
        
        
    }
    
    public int find_max (ArrayList <Integer> arr) {
        
        int len = arr.size(); //size of arr
        int tmp =0;
        
        for (int i=0; i< len; i++ )
        { 
            if (tmp < (int)arr.get(i) ) {
                tmp=(int)arr.get(i);
            }
        }
        
        System.out.println ("Inside find_max");
        return tmp;
        
    }
    
    public void print_list(){
        
        System.out.print ( "Printing Array Values:");
        for ( int k=0; k< arr.size(); k++) {
        System.out.print ( " "+ arr.get(k));
        }
        System.out.println ("");
    }
    
    
     public static void main(String []args){
        
        CountSort s = new CountSort ();
        s.arr.add(1);
        s.arr.add(4);
        s.arr.add(6);
        s.arr.add(8);
        s.arr.add(3);
        s.print_list();
        s.sort(s.arr);
        
        
        
     }
}
