//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//Example:
//Given nums = [2, 7, 11, 15], target = 9,
//return [0, 1].


import java.util.*;

public class Solution{
    
    public int[] twoSum(int[] nums, int target) {
        int [] res = {0,0};
        for (int i=0; i<=nums.length-1; i++)
            for ( int j=i+1; j<=nums.length-1; j++){
                if ( nums[i]+nums[j] == target ){
                    System.out.println("Found a match");
                    res[0]=i;
                    res[1]=j;
                    break;
                }
            }
            return res;
                
        
    }
        public static void main (String [] args) {
        
        int res[] = {0,0};
        int t, size;
        
        
        Scanner s=new Scanner(System.in);
        size=s.nextInt();
        
        int arr[] = new int[size];
        
        for(int j=0; j<size; j++)
        arr[j]=0;
        
        for(int i=0;i<4;i++){//for reading 
            arr[i]=s.nextInt();
        }
        System.out.println("TEST");
       
        
    }

    
}
