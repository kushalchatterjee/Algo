//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//Example 1:
//nums1 = [1, 3]
//nums2 = [2]
//The median is 2.0
//Example 2:
//nums1 = [1, 2]
//nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

import java.util.*;

public class Solutions{
    
    void mergeSortedArray ( int arr1[], int arr2[], int arr3[], int n1, int n2) {
        
        int i=0, j=0, k=0;
        
        while ( i<n1 && j<n2 ){
            if ( arr1[i]>arr2[j])
                arr3[k++]=arr2[j++];
            else
                arr3[k++]=arr1[i++];
            
        }
        while (i<n1)
        arr3[k++]=arr1[i++];
         while (j<n2)
        arr3[k++]=arr2[j++];
        
        for (int c=0; c<arr3.length; c++)
        System.out.println("value: "+ arr3[c]);
    }
    
    void doMedian (int arr3[]){
        int i = arr3.length;
        float median;
        if ( (i%2) == 0 ) {
            // length is even
            median = arr3[(i/2)-1];
        }
        else {
            int j = (i-1)/2;
            System.out.println("j "+ j);
            System.out.println( "arr[j-1]"+ arr3 [j-1]+ "arr[j] "+ arr3 [j]);
            median = (float)(arr3 [j-1]+ arr3 [j])/2;
            
        }
        
        System.out.println("median "+ median);
    }

     public static void main(String []args){
         
        int[] arr1 = {1, 3, 5, 7, 8};
        int n1 = arr1.length;
     
        int[] arr2 = {2, 4, 6, 8};
        int n2 = arr2.length;
        
        int[] arr3 = new int[n1+n2];
        
        Solutions s = new Solutions();
        s.mergeSortedArray ( arr1, arr2, arr3, n1, n2);
        s.doMedian ( arr3 );
        
        
        
        
     }
}
