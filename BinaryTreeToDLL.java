// Convert a Binary Tree to DLL in the order of inordertraversal
// Steps :
// Do in order traversal using recursion
// While doing so 
// 1. add nodes to DLL. 
// 2. Keep a prev pointer to keep track of previous node.
// 3. Mark prev.right as current node and current node's left as previous pointer

import java.util.*;

public class BinaryTreeToDLL {
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
    
    public void binaryTreeToDLL (Node root){
        
        if ( root == null ) {
            return;
        }
        

        
        binaryTreeToDLL (root.left);
        
        System.out.print(root.data + " ");
        
            
        if (prev == null ) {
            head = root;
                
        }
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
            
        binaryTreeToDLL (root.right);
        
        
    }

    public void printList (Node n){
        while ( n != null ) {
            System.out.print (n.data + " ");
            n = n.right;
        }
        
    }
    
    public static void main ( String [] args) {
        
        BinaryTreeToDLL tree = new BinaryTreeToDLL();
        tree.head = null;
        tree.prev = null;
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        
        System.out.println ("Inorder traversal :");
        tree.binaryTreeToDLL(tree.root);
        System.out.println ("");
        
        System.out.println ("DLL traversal :");
        tree.printList(tree.head);
        System.out.println ("");
        

    }
    
    
}
