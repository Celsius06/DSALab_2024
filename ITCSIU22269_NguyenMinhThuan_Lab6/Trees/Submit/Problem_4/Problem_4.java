// Define two binary trees to be identical if both are empty or their roots are equal, their left
// subtrees are identical, and their right subtrees are identical. Design a method that determines whether
// two binary trees are identical (this method takes a second binary tree as its only parameter and returns
// a Boolean value: true if the tree receiving the message is identical to the parameter, and false
// otherwise).

package Trees.Submit.Problem_4;

import java.io.*;
import java.util.*;

public class Problem_4 {
    public static void main(String[] args) throws IOException {
        // Define your binary trees
        Tree tree1 = new Tree();
        tree1.insert(50, 1.5);
        tree1.insert(25, 1.2);
        tree1.insert(75, 1.7);

        Tree tree2 = new Tree();
        tree2.insert(50, 1.5);
        tree2.insert(25, 1.2);
        tree2.insert(75, 1.7);

        // Check if the trees are identical
        boolean areIdentical = tree1.isIdentical(tree2);
        System.out.println("Trees are identical: " + areIdentical);
    }
}

class Node {
    public int iData; // data item (key)
    public double dData; // data item
    public Node leftChild; // this node's left child
    public Node rightChild; // this node's right child

    public void displayNode() { // display ourself
        System.out.print('{');
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("} ");
    }
}

class Tree {
    Node root;

    public void insert(int id, double dd) {
        Node newNode = new Node(); // make new node
        newNode.iData = id; // insert data
        newNode.dData = dd;
        if (root == null) // no node in root
            root = newNode;
        else { // root occupied
            Node current = root; // start at root
            Node parent;
            while (true) { // (exits internally)
                parent = current;
                if (id < current.iData) { // go left?
                    current = current.leftChild;
                    if (current == null) { // if end of the line,
                        parent.leftChild = newNode;
                        return;
                    }
                } else { // or go right?
                    current = current.rightChild;
                    if (current == null) { // if end of the line
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    // Methods to determines whether two binary trees are identical
    public boolean isIdentical(Tree otherTree) {
        return areIdentical(this.root, otherTree.root);
    }

    private boolean areIdentical(Node node1, Node node2) {
        // If both nodes are null, they are identical
        if (node1 == null && node2 == null) {
            return true;
        }
        // If one node is null and the other is not, they are not identical
        if (node1 == null || node2 == null) {
            return false;
        }
        // If the data of the nodes is not equal, they are not identical
        if (node1.iData != node2.iData) {
            return false;
        }
        // Recursively check left and right subtrees
        return areIdentical(node1.leftChild, node2.leftChild) && areIdentical(node1.rightChild, node2.rightChild);
    }
}
