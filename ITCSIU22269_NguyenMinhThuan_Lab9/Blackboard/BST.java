import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BST {
    class Node {
        int data;
        Node left, right;
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    private Node root;

    // Constructor
    public BST() {
        root = null;
    }

    // 1. Insert a node
    public void insert(int data) {

    }

    // 2. Find the height of the tree
    public int findHeight() {

    }

    // 3. Check if the tree is a valid BST
    public boolean isValidBST() {

    }

    // 4. Level-order traversal
    public List<Integer> levelOrderTraversal() {

    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        int height = tree.findHeight(); // should return the height of the tree
        System.out.println("Height of the tree: " + height); // Print the height

        boolean isValid = tree.isValidBST(); // should return true if valid
        System.out.println("Is valid BST: " + isValid); // Print if it's a valid BST

        List<Integer> levelOrderList = tree.levelOrderTraversal(); // should return [50, 30, 70, 20, 40, 60, 80]
        System.out.println("Level order traversal: " + levelOrderList); // Print the level-order traversal
    }
}