package Trees.Submit.Problem_Huffman;

import java.io.*;
import java.util.*;

public class Huffman {
    public static void main(String[] args) throws IOException {
        String text = "I am a student at International University. My name is Nguyen Minh Thuan. I am working on a DSA lab";

        // Step 1: Calculate the frequency of each character
        int[] frequencyArray = new int[128]; // Assuming ASCII characters

        for (char c : text.toCharArray()) {
            int index = (int) c; // Convert character to ASCII value
            frequencyArray[index]++;
        }

        // Step 2: Create leaf nodes for each character with their corresponding
        // frequencies
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));
        for (int i = 0; i < frequencyArray.length; i++) {
            if (frequencyArray[i] > 0) {
                priorityQueue.offer(new Node((char) i, frequencyArray[i]));
            }
        }

        // Step 3-4: Construct the Huffman coding tree
        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node parent = new Node('\0', left.frequency + right.frequency); // Internal node
            parent.leftChild = left;
            parent.rightChild = right;
            priorityQueue.offer(parent);
        }

        // Step 5: The remaining node in the priority queue is the root of the Huffman
        // coding tree
        Node root = priorityQueue.poll();

        // Display the Huffman coding tree
        System.out.println("Huffman Coding Tree:");
        displayHuffmanTree(root, "", true);

        // Generate and print Huffman codes
        System.out.println("\nHuffman Codes:");
        printHuffmanCodes(root, "");
    }

    // Utility method to display the Huffman coding tree
    private static void displayHuffmanTree(Node node, String prefix, boolean isTail) {
        if (node != null) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") +
                    (node.character == '\0' ? "F:" + node.frequency : node.character));
            if (node.leftChild != null || node.rightChild != null) {
                displayHuffmanTree(node.leftChild, prefix + (isTail ? "    " : "│   "), false);
                displayHuffmanTree(node.rightChild, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }

    // Utility method to print Huffman codes
    private static void printHuffmanCodes(Node node, String code) {
        if (node != null) {
            // If it's a leaf node, print the character and its code
            if (node.isLeaf()) {
                System.out.println(node.character + ": " + code);
            } else {
                // Traverse left with code '0'
                printHuffmanCodes(node.leftChild, code + "0");
                // Traverse right with code '1'
                printHuffmanCodes(node.rightChild, code + "1");
            }
        }
    }

    // Inner class representing a node in the Huffman coding tree
    static class Node {
        char character; // Character stored in this node
        int frequency; // Frequency of the character
        Node leftChild; // Left child node
        Node rightChild; // Right child node

        Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        // Method to check if this node is a leaf node
        boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }
    }
}
