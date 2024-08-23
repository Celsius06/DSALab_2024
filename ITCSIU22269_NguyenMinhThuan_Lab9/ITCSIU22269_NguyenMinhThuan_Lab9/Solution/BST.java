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
        root = insertRecord(root, data);
    }

    // Helper method for the recursive insertion
    private Node insertRecord(Node root, int data) {
        // Base case: if the current node is null, create a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Recursively insert the data in the left or right subtree
        if (data < root.data) {
            root.left = insertRecord(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecord(root.right, data);
        }

        // Return the unchanged node pointer
        return root;
    }

    // 2. Find the height of the tree
    public int findHeight() {
        return findBSTHeight(root);
    }

    // Helper method for recursive height calculation
    private int findBSTHeight(Node node) {
        // Base case: if the node is null, return -1 (height of an empty tree)
        if (node == null) {
            return -1;
        }

        // Recursively find the height of the left and right subtrees
        int leftHeight = findBSTHeight(node.left);
        int rightHeight = findBSTHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 3. Check if the tree is a valid BST
    public boolean isValidBST() {
        return validBSTChecker(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Helper method for recursive BST validation
    private boolean validBSTChecker(Node node, int min, int max) {
        // Base case: if the node is null, return true
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return validBSTChecker(node.left, min, node.data) && validBSTChecker(node.right, node.data, max);
    }

    // 4. Level-order traversal
    public List<Integer> levelOrderTraversal() {
        List<Integer> result = new ArrayList<>();

        // Base case: if the root is null, return an empty list
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // We traverse through the tree level by level
        while (!queue.isEmpty()) {
            Node node = queue.poll(); // Dequeue the front node
            result.add(node.data); // Add the node's data to the result list

            // Enqueue the left and right children of the current node
            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return result; // Return the list of node values in level-order
    }

    // Main method for testing the code
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