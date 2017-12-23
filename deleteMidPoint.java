// Given a linked list of co-ordinates where adjacent points either form a vertical line or horizontal line. Delete points from the linked list which are in the middle of a horizontal or vertical line.
//Examples:
//Input:  (0,10)->(1,10)->(5,10)->(7,10)
//                                  |
//                                (7,5)->(20,5)->(40,5)
//Output: Linked List should be changed to following
//        (0,10)->(7,10)
//                  |
//               (7,5)->(40,5) 
//The given linked list represents a horizontal line from (0,10) 
//to (7, 10) followed by a vertical line from (7, 10) to (7, 5), 
//followed by a horizontal line from (7, 5) to (40, 5).

//Input:     (2,3)->(4,3)->(6,3)->(10,3)->(12,3)
//Output: Linked List should be changed to following
//    (2,3)->(12,3) 
//There is only one vertical line, so all middle points are removed.

import java.util.*;

public class DeleteMidPoints{
    
    public Node head = null;
    public class Node {
        int val1;
        int val2;
        Node next;
    }
    
    public Node insert ( Node head, int i, int j) { //inserts node at the beginning
        Node n = new Node();
        n.val1 = i;
        n.val2 = j;
        n.next = head;
        head = n;
        
        return head;
    }
    
    public void printList (Node head) {
        
        while (head != null) {
            System.out.print ("("+ head.val1 +"," + head.val2 + ")");
            head = head.next;
        }
        System.out.println("");
    }
    
    public void deleteMid ( Node head )
    {
        Node prev=head;
        Node curr = head.next;
        
        
        while ( curr != null && curr.next != null ) {
            
             //System.out.println ( "prev.val1 : " + prev.val1 + ", prev.val2 :" + prev.val2);
             //System.out.println ( "curr.val1 : " + curr.val1 + ", curr.val2 :" + curr.val2);
             if ( prev.val1 == curr.val1 ){
                 System.out.println ( "Vertical Line");
                 if ( curr.val1 == curr.next.val1) {
                     System.out.println ( "curr.next is also on vertical Line");
                     prev.next = curr.next;
                     curr = null;
                     curr=prev.next;
                 } else {
                    prev = prev.next;
                    curr= curr.next;
                 }
             }
             else if (prev.val2 == curr.val2) {
                 System.out.println ( "Horizontal Line");
                 if ( curr.val2 == curr.next.val2) {
                     System.out.println ( "curr.next is also on horizontal Line");
                     prev.next = curr.next;
                     curr = null;
                     curr=prev.next;
                 } else {
                    prev = prev.next;
                    curr= curr.next;
                 }
                 
             }
        }
        
    }
    
    
    public static void main(String []args){
        DeleteMidPoints d = new DeleteMidPoints();
        
        d.head = d.insert (d.head, 0,8);
        d.head = d.insert (d.head, 0,10);
        d.head = d.insert (d.head, 5,10);
        d.head = d.insert (d.head, 7,10);
        d.head = d.insert (d.head, 10,10);
        d.head = d.insert (d.head, 10,15);
        d.head = d.insert (d.head, 10,20);
        d.head = d.insert (d.head, 10,25);
        d.head = d.insert (d.head, -10,25);
        
        
        
        
        System.out.println ("Printing the list");
        d.printList(d.head);
        
        d.deleteMid ( d.head );
        System.out.println ("Printing the list");
        d.printList(d.head);
        
        
     }
}
