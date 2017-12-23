import java.util.*;

public class Sum3{
    
    public Node head1 = null;
    public Node head2 = null;
    public Node head3 = null;
    
    public class Node {
        int val;
        Node next;
    }
    
    public Node insert ( Node head, int i) { //inserts node at the beginning
        Node n = new Node();
        n.val = i;
        n.next = head;
        head = n;
        
        return head;
    }
    
    public void printList (Node head) {
        
        while (head != null) {
            System.out.print (head.val+" ");
            head = head.next;
        }
        System.out.println("");
    }
    
    public Node ascMergeSort(Node head) {
        
        if ( head == null || head.next == null ) {
            return head;
        }
        Node mid = find_Mid(head); // find the median
        Node sHalf = mid.next; mid.next = null; // Split the list into two half
        Node h = ascMerge ( ascMergeSort (head), ascMergeSort (sHalf) );
        
        return h;
    }
    
    public Node descMergeSort(Node head) {
        
        if ( head == null || head.next == null ) {
            return head;
        }
        Node mid = find_Mid(head); // find the median
        Node sHalf = mid.next; mid.next = null; // Split the list into two half
        Node h = descMerge ( descMergeSort (head), descMergeSort (sHalf) );
        
        return h;
    }
    
    public Node find_Mid(Node head) {
        Node slow = head; 
        Node fast = head;
        
        while ( fast.next !=null && fast.next.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public Node ascMerge ( Node n1, Node n2 ){
        Node curr = null;
        if ( n1 ==null ) return n2;
        if ( n2 ==null ) return n1;
        
        if (n1.val < n2.val ) {
            curr = n1;
            curr.next = ascMerge (n1.next, n2);
            
        }
        else {
            curr = n2;
            curr.next = ascMerge (n1, n2.next);
        }
        return curr;
    }
    
    public Node descMerge ( Node n1, Node n2 ){
        Node curr = null;
        if ( n1 ==null ) return n2;
        if ( n2 ==null ) return n1;
        
        if (n1.val > n2.val ) {
            curr = n1;
            curr.next = descMerge (n1.next, n2);
            
        }
        else {
            curr = n2;
            curr.next = descMerge (n1, n2.next);
        }
        return curr;
    }
    
    public void find3Sum ( Node n1, Node n2, Node n3, int k) {
        Node a = n1;
        
        while (a !=null ) {
            
            Node b = n2;
            Node c = n3;
            
            while ( b != null && c != null ){
                
                int sum = a.val + b.val + c.val;
                
                //System.out.println ("a, b c are : " + a.val +" "+ b.val +" " + c.val);
                
                if ( sum == k) {
                    System.out.println ("Value found. a, b c are : " + a.val +" "+ b.val +" " + c.val);
                }
                
                if ( sum < k) {
                    b = b.next;
                }
                else  {
                    c = c.next;
                }
            }    
            a = a.next;
            
        }
    }
    public static void main(String []args){
        Sum3 s = new Sum3();
        s.head1=s.insert (s.head1, 12); s.head1=s.insert (s.head1, 3); s.head1=s.insert (s.head1, 6); 
        s.head1=s.insert (s.head1, 22); s.head1=s.insert (s.head1, 32);
        
        s.head2=s.insert (s.head2, 10); s.head2=s.insert (s.head2, 2); s.head2=s.insert (s.head2, 5); 
        s.head2=s.insert (s.head2, 23); s.head2=s.insert (s.head2, 8);
        
        s.head3=s.insert (s.head3, 0); s.head3=s.insert (s.head3, 7); s.head3=s.insert (s.head3, 6); 
        s.head3=s.insert (s.head3, -11); s.head3=s.insert (s.head3, -5);
        
        System.out.println ("Printing the first list");
        s.printList(s.head1);
        System.out.println ("Printing the second list");
        s.printList(s.head2);
        System.out.println ("Printing the third list");
        s.printList(s.head3);
        
        s.head2 = s.ascMergeSort(s.head2);
        System.out.println ("Printing the second list after sort");
        s.printList(s.head2);
        
        s.head3 = s.descMergeSort(s.head3);
        System.out.println ("Printing the third list after sort");
        s.printList(s.head3);
        
        System.out.println ("Finding Sum...");
        s.find3Sum ( s.head1, s.head2, s.head3, 16) ;
     }
}
