// WORK IN PROGRESS ( NEED TO TEST ) 
//Build a BST from an array which is a preOrder Traversal
// The steps are -
// 1. The first element is root
// 2. Then recursively traverse the array satisfying teh following conditon -
//    2.a every node which is less than the current should be in left subtree
//    2.b every node which is greater than the current should be in right subtree

import java.util.*; 

public class buildBST_preOrder {
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
    
    public class Index {
        int index = 0;
    }
    // build Tree from sorted array assumes the array is sorted
    // Find the root in the middle.
    //Then recursively build left & right subtree
    public Node treeUtil (ArrayList<Integer> arr, Index preInd, int key, int min, int max, int size) {
        
        
        if ( preInd.index >= size || min > max )
            return null;
            
        Node root = null;
        
        System.out.println ( "ind : " + preInd.index + " size :"+ size + " key :"+key);
        
        if ( key > min && key < max ) {
            
            
            root = new Node(key);
            preInd.index = preInd.index+1;
            
            if ( min == max)
                return root;
            
            if ( preInd.index < size ) {
                
                System.out.println ( "Inside IF ind : " + preInd.index );
                root.left = treeUtil (arr, preInd, arr.get(preInd.index),  min,  key, size); //left tree
                
                root.right = treeUtil (arr, preInd, arr.get(preInd.index), key, max, size); //right tree
            }
        }
        
        return root;
        
    }
    
    public Node buildTree ( ArrayList <Integer> arr, int size ) {
       
        Index preInd = new Index();
        preInd.index = 0;
        
        Node root = treeUtil (arr, preInd, arr.get(0), Integer.MIN_VALUE, Integer.MAX_VALUE,  size); //left tree
        
        return root;
    }
    
    public Node insert ( Node root, int key ) {
        if ( root == null ) {
            System.out.println ("TEST1");
            root = new Node (key);
            return root;
        }
        else {
            if ( root.val <key )
            insert ( root.right, key);
            else if ( root.val > key )
            insert ( root.left, key);
        }
        return root ;
    }
    
    public void inorderTraversal (Node root) { //left child->root->rightchild
        
        
        if ( root == null ) return;
        inorderTraversal (root.left);
        System.out.print (root.val+ " ");
        inorderTraversal (root.right);
        
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
        arr.add (10);
        arr.add (5);
        arr.add (1);
        arr.add (7);
        arr.add (40);
        arr.add (50);
        Node root = b.buildTree ( arr, arr.size() );
        System.out.print ("In order Traversal : ");
        b.inorderTraversal ( root );
        System.out.println ("");
        
        b.insert ( root, 10 );
        
        System.out.print ("Pre-order Traversal : ");
        b.preorderTraveral ( root );
        System.out.println ("");
        
        System.out.print ("Post-order Traversal : ");
        b.postorderTraveral ( root );
        System.out.println ("");
        
        
     }
}
