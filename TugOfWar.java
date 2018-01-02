public class TugOfWar {
    static int N = 8;
    
    static int minDiff = Integer.MAX_VALUE;
    
  // Recursive routine for finding Tug of War solution
  // 1. in each iteration, either add or remove the current element from the selected array
  // 2. check if we have already selected the requried number of elements, in that case update solution
  // 3. check if have already reached the end of the array, in that case, simply return
  
  
    public static void solveTugOfWar(int currIndex, int len, int [] arr, boolean [] selected, boolean [] sol){
        int selectedSize=0;
        for ( int i=0; i< len; i++){
            if ( selected[i])
                selectedSize++;
        }
        
        System.out.println ( "selectedSize" + selectedSize);
        
        if ( selectedSize == len / 2 ){
            System.out.println ( "selectedSize" + selectedSize);
            int diff = getDiff(arr, selected, len);
            if ( diff < minDiff ){ 
                minDiff = diff;
                updateSolution(selected, sol, len);
            }
        }
        
        if ( currIndex >= len )
            return;
        
        selected[currIndex] = true;
        solveTugOfWar ( currIndex+1, len, arr, selected, sol);
        
        selected[currIndex] = false;
        solveTugOfWar ( currIndex+1, len, arr, selected, sol);
        
        
    }
    
    public static void updateSolution (boolean [] selected, boolean [] sol, int len){
        for ( int i=0; i<len; i++){
            sol[i] = selected[i];
        }
        
    }
    
    public static void printSolution(int [] arr, boolean []sol, int len) {
        for ( int i=0; i< len; i++) {
            if ( sol[i])
                System.out.print(arr[i]+",");
        }
        System.out.println("");
        
        for ( int i=0; i< len; i++) {
            if ( !sol[i]) 
                System.out.print(arr[i]+",");
        }
        
        System.out.println("");
    }
    public static int getDiff (int [] arr, boolean [] selected, int len) {
        int leftSum=0, rightSum=0;
        for ( int i=0; i<len; i++){
            if ( selected[i])
                leftSum += arr[i];
            else 
                rightSum += arr[i];
            
        }
        return Math.abs(leftSum-rightSum);
    }
    
    public static void main(String args[]) {
        int [] arr = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};
        int len = arr.length;
        boolean [] selected = new boolean [len];
        boolean [] sol = new boolean [len];
        
        solveTugOfWar(0, len, arr, selected, sol);
        printSolution(arr, sol, len);
    }
}
