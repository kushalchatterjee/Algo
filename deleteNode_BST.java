import java.util.*; 

public class deleteNode_BST {
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
        System.out.println ("mid :" + mid + " Value:" + root.val );
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
    
    public void preorderTraveral (Node root) { // root->left child->rightchild
        
        
        if ( root == null ) return;
        System.out.print (root.val+ " ");
        preorderTraveral (root.left);
        preorderTraveral (root.right);
        
    }
    
    public void delete (Node root) { // delete node by post-order traversal
        
        
        if ( root == null ) return;
        
        delete (root.left);
        delete (root.right);
        
        System.out.println ("Delete root.val " + root.val);
        root = null;
        
    }
    
    void deleteTreeRef(Node nodeRef)
    {
        delete(nodeRef);
        nodeRef=null;
    }
    
    public void postorderTraveral (Node root) { // left child->rightchild->root
        
        
        if ( root == null ) return;
        postorderTraveral (root.left);
        postorderTraveral (root.right);
        System.out.print (root.val+ " ");
        
    }

    public Node search (Node root, int key) { // left child->rightchild->root
        
        Node n =null;
        if ( root == null ) return null;
    
        if ( root.val > key) {
            System.out.println ("Node value is "+ root.val +" Left traversal for key= " + key);
            n=search (root.left, key);
        }
        else if ( root.val< key) {
            System.out.println ("Node value is "+ root.val + " Right traversal for key = " + key);
            n=search (root.right, key);
        }
        else if ( root.val == key) {
            System.out.println ( "Node value is "+ root.val + " Found the node");
            n = root;
        }
        return n;
        
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
        arr.add (10);
        arr.add (30);
        Node root = b.buildTree ( arr, 0, arr.size()-1 );
        
        Node n = b.search ( root, 6);
        System.out.println ( "Returned node " + n.val);
        
        b.deleteTreeRef(n);
        
        System.out.print ("In order Traversal : ");
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
