import java.util.*;

public class HeapSort{
    public ArrayList <Integer> arr;
    public HeapSort (){
        arr = new ArrayList <Integer> ();
    }
    
    public void sort (){
        int n = arr.size();
        
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            
            
            heapify(arr, n, i);
            System.out.println ("With root i :" + i);
            print_list();
            
        }
        
        for(int i = n-1; i >= 1 ; i-- )
        {
            //swap (Arr[ 0 ], Arr[ i ]);
            
            int temp = arr.get(0);
            arr.set(0, arr.get(i) );
            arr.set(i, temp );
            
            heapify(arr, i, 0);
        }
        
    }
    
    public void heapify (ArrayList <Integer> arr, int n, int i) {
        int largest = i; //initialize the largest with root
        int l = i*2+1; //left child
        int r = i*2+2; //right child
        
        System.out.println ("i :" + i + " l :"+ l + " r :"+ r);
        if ( l<n && ( (int) arr.get(l) > (int) arr.get(largest) ) ) {
            largest = l;
        }
        
        if ( r< n && ( (int)  arr.get(r) > (int) arr.get(largest) ) ){
            largest = r;
        }
        
        
        
        if ( largest != i ) {
            System.out.println ("largest " + largest);
            int swap = arr.get(i);
            arr.set(i, arr.get(largest) );
            arr.set(largest, swap );
            
            
            
            heapify(arr, n, largest);
        }
        
        
    }
    
    public void print_list(){
        
        System.out.print ( "Printing Array Values:");
        for ( int k=0; k< arr.size(); k++) {
        System.out.print ( " "+ arr.get(k));
        }
        System.out.println ("");
    }
    
     public static void main(String []args){
        
        HeapSort s = new HeapSort ();
        s.arr.add(11);
        s.arr.add(4);
        s.arr.add(6);
        s.arr.add(8);
        s.arr.add(3);
        s.print_list();
        s.sort();
        System.out.println ("Printing after sort");
        s.print_list();
        
        
     }
}
