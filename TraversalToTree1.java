// Given two arrays, one preorder traversal, and another postorder traversal, build a complete binary tree
// complete binary tree's are trees which either have 0 or 2 vhildren of each node

import java.util.*;

public class TraversalToTree1 {
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
    public static int preIndex;
    
    public Node buildTree(int [] pre, int []post, int start, int end, int len) {
        
        if ( preIndex >=len || start > end )
            return null;
            
        Node root = new Node (pre[preIndex++]); // create a node from first index
        
        if ( start == end || preIndex >= len )
            return root;
            
        int postIndex = search ( post, start, end, pre[preIndex]);
        
        if ( postIndex <= end ) {
            root.left = buildTree( pre, post, start, postIndex,len);
            root.right = buildTree( pre, post, postIndex+1, end, len );
        }
        
        return root;
    }
    
    public int search ( int [] post , int start, int end, int data) {
        for ( int i = start; i <= end; i++) {
            if ( post[i] == data )
                return i;
        }
        return -1;
    }
    
    public void inorderTraversal (Node root) {
        
        if ( root == null ) return;
        
        inorderTraversal ( root.left);
        System.out.print (root.data+ " " );
        inorderTraversal ( root.right);
    }
    public static void main ( String [] args) {
        
        int pre[] = new int[]{1, 2, 4, 8, 9, 5, 3, 6, 7};
        int post[] = new int[]{8, 9, 4, 5, 2, 6, 7, 3, 1};
        
        
        
        int len = pre.length;
        TraversalToTree1 tree = new TraversalToTree1();
        
        tree.root = tree.buildTree ( pre, post, 0, len -1, len);
        
        System.out.print ("Inorder Traversal : ");
        tree.inorderTraversal (tree.root);
        

    }
    
    
}
