// 1. You are given two non-empty linked lists representing two non-negative integers. 
// 2. The digits are stored in reverse order and each of their nodes contain a single digit. 
// 3. Add the two numbers and return it as a linked list.
// 4. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// Example : Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8

import java.util.*;

public class Solutions{
    
    LinkedList<Integer> l1;
    LinkedList<Integer> l2;
    
    Solutions ()
    {
        
        this.l1 = new LinkedList<Integer>();
        this.l2 = new LinkedList<Integer>();
    }
    
    public static void addValues (Solutions s)
    {
        
        s.l1.add ( new Integer(2) );
        s.l1.add ( new Integer(4) );
        s.l1.add ( new Integer(3) );
        
        System.out.println("Printing Linked List 1"); 
        
        Iterator<Integer> itr1=s.l1.iterator();  
        while(itr1.hasNext()){  
          System.out.println(itr1.next());  
        } 
        
        System.out.println("Printing Linked List 2"); 
        s.l2.add ( new Integer(5) );
        s.l2.add ( new Integer(6) );
        s.l2.add ( new Integer(4) );
        
        Iterator<Integer> itr2=s.l2.iterator();  
        while(itr2.hasNext()){  
          System.out.println(itr2.next());  
        } 
        
    }
    public LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        
        LinkedList<Integer> l3 = new LinkedList<Integer>();
        
        ListIterator<Integer> firstItr = l1.listIterator();
        ListIterator<Integer> secItr = l2.listIterator();
        
        
        System.out.println("Traversing LinkedList 1"); 
        while(firstItr.hasNext()){  
          System.out.println(firstItr.next());  
        } 
        
        System.out.println("Now traversing LinkedList 2 forward, LinkedList 1 backward"); 
        
        Integer intg=0, modulo=0; // variables used for sum and modulo
        
        while (firstItr.hasPrevious() && secItr.hasNext() )
        {
            
            intg= (firstItr.previous()+secItr.next())+modulo;
            if (intg >=10 ){
                intg %= 10 ;
                modulo = 1;
            }
            
            System.out.println(intg);
            l3.offerFirst(intg);
        }
        
        ListIterator<Integer> thirdItr = l3.listIterator();
        
        
        System.out.println ("Traversing LinkedList 3"); 
        
        while(thirdItr.hasNext()){  
          System.out.println(thirdItr.next());  
        } 
        
        return l3;
    }

     public static void main(String []args){
         
        //LinkedList<Integer> finList = new LinkedList<Integer>();
        Solutions s = new Solutions();
        System.out.println("Hello");
        addValues(s);
        //finList=s.addTwoNumbers(s.l1, s.l2);
        //System.out.println(finList);
        
        System.out.println(s.addTwoNumbers(s.l1, s.l2));
        
        
        
     }
}
