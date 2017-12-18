// Build a Tree from Inorder Traversal
// Write a method to iteative perform inorder traversal

import java.util.*; 

public class BinarySearchTree {
    public class Node {
        int val;
        Node left;
        Node right;
    
    
        public Node (int i) {
            val = i;
            left = null;
            right = null;
        }
    }
    // build Tree from sorted array assumes the array is sorted
    // Find the root in the middle.
    //Then recursively build left & right subtree
    public Node buildTree ( ArrayList <Integer> arr, int start, int end ) {
        if ( start > end ) return null;
        int mid = start+ (end - start )/2;
        Node root = new Node (arr.get(mid));
        root.left = buildTree ( arr, start, mid-1);
        root.right = buildTree ( arr, mid+1, end); 
        
        return root;
        
    }
    
    public void inorderTraversal (Node root) { //left child->root->rightchild
        
        
        if ( root == null ) return;
        inorderTraversal (root.left);
        System.out.print (root.val+ " ");
        inorderTraversal (root.right);
        
    }
    // Inorder traversal - iterative. Uses a stack.
    // 1. Push the root ( If root is null return)
    // 2. Continue to visit thorugh the left children until reaching null. 
    //    Along the way keep pushing to stack.
    // 3. Once null is reached, pop the queue. Print the node.
    // 4. If popped node has right queue, go to step 2.
    // 5. Else, pop the next node.
    // 6. If the stack is empty, traveral ends.
    public void inorderTraversalStack (Node root) { 
        
        Stack <Node> s1 = new Stack <Node> ();
        
        if ( root == null ) return;
        
        Node tmp = root;
        while ( tmp != null ) {
            s1.push(tmp);
            tmp = tmp.left;
        }
        
        
        while ( !s1.isEmpty() ) {
            tmp=s1.pop();
            System.out.print (tmp.val + " ");
            if ( tmp.right != null ) {
                tmp = tmp.right;
                while ( tmp != null ) {
                    s1.push(tmp);
                    tmp = tmp.left;
                }
            }
            
        }
        
    }
    
    public void preorderTraveral (Node root) { // root->left child->rightchild
        
        
        if ( root == null ) return;
        System.out.print (root.val+ " ");
        inorderTraversal (root.left);
        inorderTraversal (root.right);
        
    }
    
    public void postorderTraveral (Node root) { // left child->rightchild->root
        
        
        if ( root == null ) return;
        inorderTraversal (root.left);
        inorderTraversal (root.right);
        System.out.print (root.val+ " ");
        
    }

     public static void main(String []args){
        ArrayList <Integer> arr = new ArrayList <Integer> ();
        BinarySearchTree b = new BinarySearchTree();
        arr.add (1);
        arr.add (2);
        arr.add (3);
        arr.add (4);
        arr.add (5);
        arr.add (6);
        Node root = b.buildTree ( arr, 0, arr.size()-1 );
        System.out.print ("In order Traversal using Stack: ");
        b.inorderTraversalStack ( root );
        System.out.println ("");
        
        System.out.print ("In order Traversal (recursive without stack) :");
        b.inorderTraversal ( root );
        System.out.println ("");
        
        System.out.print ("Pre-order Traversal : ");
        b.preorderTraveral ( root );
        System.out.println ("");
        
        System.out.print ("Post-order Traversal : ");
        b.postorderTraveral ( root );
        System.out.println ("");
        
     }
}
