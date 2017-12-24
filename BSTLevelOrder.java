//Build a tree from Inorder Traversal 
//Do Breadth First Search or Level Order Traversal for Binary Search Tree
//Time complexity is O(n)

import java.util.*;

public class BSTLevelOrder {
    
    public class Node {
        int val;
        Node left;
        Node right;
        
        public Node (int i) {
            val =i;
            left = null;
            right = null;
        }
    }
    
    public Node buildTree ( ArrayList<Integer> arr, int start, int end) {
        if ( start > end ) return null;
        
        int mid = start + ( end - start) /2;  
        Node root = new Node (mid);
        root.left = buildTree ( arr, start, mid-1);
        root.right = buildTree ( arr, mid+1, end);
        
        return root;
        
    }
    
    public void levelOrderTraverse (Node root) {
        LinkedList<Node> q = new LinkedList<Node> ();
        q.add(root);
        
        while (q.size() != 0 ){
            Node n = q.remove();
            System.out.print( n.val + " ");
            
            if (n.left != null ) {
                q.add(n.left);
            }
            
            if (n.right != null ) {
                q.add(n.right);
            }
            
        }
        
        
        
    }
    
    
    public static void main(String []args){
        ArrayList <Integer> arr = new ArrayList <Integer> ();
        BSTLevelOrder b = new BSTLevelOrder();
        arr.add (1);
        arr.add (2);
        arr.add (3);
        arr.add (4);
        arr.add (5);
        arr.add (6);
        Node root = b.buildTree ( arr, 0, arr.size()-1 );
        b.levelOrderTraverse(root);
     }

}
