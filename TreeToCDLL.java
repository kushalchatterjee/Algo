// Given a BST build a Circiular Doubly Linked List
// Steps :
// Do inorder traversal of the tree. While doing so
//      a. keep track of previously visted nodes using a pointer prev
//      b. make prev.right as current and current.left as prev
// After the traversal is finished prev should point to last node of the list. Make prev.right as head and head.left as prev.
// Traverse the CDLL 

import java.util.*;

public class TreeToCDLL {
    public static class Node {
        int data;
        Node left;
        Node right;
        
        public Node ( int i) {
            data = i;
            left = null;
            right = null;
        }
    }
    public Node root;
    public Node head;
    public Node prev;
    public Node current;
    
    public void bTreeToCListUtil(Node root) {
        if ( root == null ) return;
        
        bTreeToCListUtil(root.left);
        
        if( prev == null ) {
            head = root;
        } else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;
        
        bTreeToCListUtil(root.right);
    }
    
    public void bTreeToCList() {
        prev = null; head = null;
        bTreeToCListUtil(root);
    }
    
    public void display() {
        
        System.out.print (head.data + " ");
        
        //System.out.println (prev.right.data + " ");
        
        Node n = head.right;
        while ( n != head) {
            System.out.print (n.data + " ");
            n = n.right;
        }
        System.out.println ("");
        
    }
    
    // Driver Code

    public static void main(String args[])
    {
        // Build the tree
        TreeToCDLL tree = new TreeToCDLL();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
 
        // head refers to the head of the Link List
        tree.bTreeToCList();
        
        if ( tree.head != tree.prev ) {
            //System.out.println ( "head :" + tree.head.data + " " + "prev :" + tree.prev.data);
            tree.prev.right = tree.head;
            tree.head.left = tree.prev;
            
        }
 
        // Display the Circular LinkedList
        tree.display();
    }

}
