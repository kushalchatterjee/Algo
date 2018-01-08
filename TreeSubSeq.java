// Given a Binary Tree find the longest subsequence of consequetive intergers 

import java.util.*;

public class TreeSubSeq {
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
    
    public int findConsUtil (Node root, int data, int c) {
        
        int leftC =0, rightC =0;
        
        if ( root == null ) return c;//Root is null. return c
        
        if (root.data == data+1 ) { // Is root's value 1 more than data ? Then recurse with c+1
            leftC = findConsUtil ( root.left, root.data, c+1);
            rightC = findConsUtil ( root.right, root.data, c+1);
            
        } else if (root.data != data+1 ) { //else, recurse with c
        
            leftC = findConsUtil ( root.left, root.data, c);
            rightC = findConsUtil ( root.right, root.data, c);
            
        }
        return leftC > rightC ? leftC : rightC; //return leftC or rightC, whichever is greater 
    }
    
    public void findConsequitiveSeq ( Node root ) {
        
        int leftC = 0, rightC = 0;
        
        if ( root == null ) {
            System.out.println("Empty Tree");
            return;
        }
        
        if ( root.left == null && root.right == null ) {
            System.out.println("Empty Left and Right Nodes, longest subsequence = 1");
            return;
        }
        int c= 1;
        
        leftC = findConsUtil (root.left, root.data, c); //Recursively call root left
        rightC = findConsUtil (root.right, root.data, c); //Recusively call root right
        
        
        System.out.println ("Largest sequence : " + ( leftC > rightC ? leftC : rightC) );
    }
    
    public void inOrder ( Node root) {
        if ( root == null) return;
        
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
        
    }
    

    public static void main(String args[])
    {
        // Build the tree
        TreeSubSeq tree1 = new TreeSubSeq();
        tree1.root = new Node(6);
        tree1.root.right = new Node(9);
        tree1.root.right.left = new Node(7);
        tree1.root.right.right = new Node(10);
        tree1.root.right.right.right = new Node(11);
        
        TreeSubSeq tree2 = new TreeSubSeq();
        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(4);
        tree2.root.left.left = new Node(3);
        tree2.root.right.left = new Node(5);
        tree2.root.right.right = new Node(6);
        tree2.root.right.right.right = new Node(7);
        
        System.out.println ("Inorder Traversal of tree1");
        tree1.inOrder(tree1.root);
        System.out.println ("");
        tree1.findConsequitiveSeq(tree1.root);
        
        System.out.println ("Inorder Traversal of tree2");
        tree1.inOrder(tree2.root);
        System.out.println ("");
        tree2.findConsequitiveSeq(tree2.root);
        
        
    }

}
