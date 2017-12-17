// 1. Create BST from inorder traversal
// 2. Iteratively do postorder traversal ( without using recursion)
import java.util.*; 

public class PostOrderBST_iterative {
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
    
    // method to do postorder traversal. Makes use of two stacks.
    public void postorderTraversalStack (Node root) {
        Stack <Node> s1 = new Stack <Node> ();
        Stack <Node> s2 = new Stack <Node> ();
        
        if ( root == null ) {
            System.out.println ("Empty Tree");
            return;
        }
        
        s1.push (root);
        while ( !s1.isEmpty() ) { //Iteratively pop s1 & push to s2 it's left and right child , as long as s1 is not empty
            Node n = s1.pop();
            s2.push(n);
            if (n.left != null )
                s1.push (n.left);
            if (n.right != null )
                s1.push (n.right);
        }
        
        
        while ( !s2.isEmpty() ) {
            System.out.print ((s2.pop()).val+ " ");
        
        }
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
        preorderTraveral (root.left);
        preorderTraveral (root.right);
        
    }
    
 

    
     public static void main(String []args){
        ArrayList <Integer> arr = new ArrayList <Integer> ();
        PostOrderBST_iterative b = new PostOrderBST_iterative();
        arr.add (1);
        arr.add (2);
        arr.add (3);
        arr.add (4);
        arr.add (5);
        arr.add (6);
        arr.add (10);
        arr.add (30);
        Node root = b.buildTree ( arr, 0, arr.size()-1 );
        
        
        
        System.out.print ("In order Traversal : ");
        b.inorderTraversal ( root );
        System.out.println ("");
        System.out.print ("Pre-order Traversal : ");
        b.preorderTraveral ( root );
        System.out.println ("");
        System.out.print ("Post-order Traversal : ");
        b.postorderTraversalStack ( root );
        System.out.println ("");
     }
}
