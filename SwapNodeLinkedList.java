// Build a Linked List. Swap alternate nodes

import java.util.*;

public class SwapNodeLinkedList {
    public class Node {
        int val;
        Node next;
        
        public Node (int i) {
            val = i;
            next = null;
         
        }
    }

   public Node insertAtBeginning ( Node head, int i) {
       Node n = new Node (i);
       n.next = head;
       head = n;

       System.out.println ( head.val);
       return head;


   }

// Swaps the alternate nodes
// Makes use of three pointers - curr, prev,nxt
// prev is used to track the previous next. For the first iteration prev is null

   public Node swapAlternate ( Node head) {
       
       Node curr = head; //curr initialized as head
       Node nxt = head.next;//nxt initialized as head.next
       Node prev = null; //prev initialized as null
       
       curr.next = nxt.next;
       nxt.next = curr;
       head = nxt;
       
       while(curr.next !=null) {
                prev = curr;
                curr = curr.next; 
                if ( curr.next == null ) { 
                        System.out.println ( "Reached last node. No pairing node exists");
                        break;
                }
                nxt=curr.next;
                
                curr.next = nxt.next;
                nxt.next = curr;
                prev.next = nxt;
        }

       return head;
   }
  
   public void traverse ( Node n) {
       while ( n != null ) {
           System.out.print ( n.val + " ");
           n = n.next;
       }

       System.out.println ("");

   }
     public static void main(String []args){

        SwapNodeLinkedList l = new SwapNodeLinkedList();
        Node head = null;

        head = l.insertAtBeginning (head, 9);
        head = l.insertAtBeginning (head, 1);


        head = l.insertAtBeginning (head, 2);


        head = l.insertAtBeginning (head, 10);

        head = l.insertAtBeginning (head, 3);


        head = l.insertAtBeginning (head, 5);
        
        l.traverse(head);

        head = l.swapAlternate ( head );

        l.traverse(head);
  }
}
