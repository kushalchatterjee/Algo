// Build a Tree from Inorder Traversal
// Write a method to do preorder traversal without recursion

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
    // Preorder traversal - iterative. Uses a stack.
    // 1. Push the root ( If root is null return)
    // While the stack is not empty, continue to do following
    // 2. Pop the stack. Print the value
    // 3. Push right child if it is not null. 
    // 4. Push left child if it is not null
    // 5. If stack is empty the traversal ends.

    public void preorderTraversalStack (Node root) { 
        
        Stack <Node> s1 = new Stack <Node> ();
        
        if ( root == null ) return;
        
        Node tmp = root;
        s1.push(tmp);
            
        
        while ( !s1.isEmpty() ) {
            tmp=s1.pop();
            System.out.print (tmp.val + " ");
            
            if ( tmp.right != null ) 
                s1.push(tmp.right);
            if ( tmp.left != null ) 
                s1.push(tmp.left);    
        }
        
    }
    
    public void preorderTraversal (Node root) { // root->left child->rightchild
        
        
        if ( root == null ) return;
        System.out.print (root.val+ " ");
        preorderTraversal (root.left);
        preorderTraversal (root.right);
        
    }
    
    public void postorderTraversal (Node root) { // left child->rightchild->root
        
        
        if ( root == null ) return;
        postorderTraversal (root.left);
        postorderTraversal (root.right);
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

        
        System.out.print ("In order Traversal :");
        b.inorderTraversal ( root );
        System.out.println ("");
        
        System.out.print ("Pre-order Traversal : ");
        b.preorderTraversal ( root );
        System.out.println ("");
        
        System.out.print ("Post-order Traversal(recursive without stack) : ");
        b.preorderTraversalStack ( root );
        System.out.println ("");
        
        System.out.print ("Post-order Traversal : ");
        b.postorderTraversal ( root );
        System.out.println ("");
        
     }
}
