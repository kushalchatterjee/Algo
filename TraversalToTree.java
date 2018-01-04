// Given two arrays, one inorder traversal, and another preorder traversal, build a binary tree

import java.util.*;

public class TraversalToTree {
    public static class Node {
        char data;
        Node left;
        Node right;
        
        public Node ( char c) {
            data = c;
            left = null;
            right = null;
        }
    }
    
    public static int preIndex;
    public Node root;
  
    public Node buildTree ( char [] in, char [] pre, int start, int end) {
        
        if ( start > end )
            return null;
        
        Node n = new Node (pre[preIndex++]); // pick a node, for first iteration starts with 0
        
        if ( start == end ) 
            return n;
        int inIndex = searchNode (in, start, end, n.data);
            
        n.left = buildTree ( in, pre, start, inIndex-1); 
        n.right = buildTree ( in, pre, inIndex+1, end ); 
        
        return n;
    }
    
    public static int searchNode (char [] in, int start, int end, char c) {
        for ( int i=start; i<=end; i ++) {
            if ( in[i] == c )
                return i;
        }
        
        return -1;
        
    }
    
    public void inorderTraversal (Node root) {
        if ( root == null )
            return;
        inorderTraversal (root.left); 
        System.out.println (root.data + " ");
        inorderTraversal (root.right); 
        
        
    }
    public static void main ( String [] args) {
        
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        TraversalToTree tree = new TraversalToTree();
        tree.root = tree.buildTree ( in, pre, 0, len -1);
        
        tree.inorderTraversal (tree.root);
        

    }
    
    
}
