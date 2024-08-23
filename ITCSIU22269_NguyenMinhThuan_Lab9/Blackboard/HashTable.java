import java.util.LinkedList;

class HashTable {
    class Entry {
        int key;
        String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int TABLE_SIZE = 10;
    private LinkedList<Entry>[] table;

    // Constructor
    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // 1. Insert a key-value pair
    public void insert(int key, String value) {
        // your code here
    }

    // 2. Delete a key
    public void delete(int key) {
        // your code here
    }

    // 3. Retrieve a value by key
    public String get(int key) {
        // your code here
    }

    // Helper method to print the table (optional)
    public void printTable() {

    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert(1, "One");
        hashTable.insert(2, "Two");
        hashTable.insert(3, "Three");
        hashTable.delete(2);
        String value = hashTable.get(1); // should return "One"
        String missingValue = hashTable.get(2); // should return null

        System.out.println("Value for key 1: " + value); // Output: One
        System.out.println("Value for key 2: " + missingValue); // Output: null

        hashTable.printTable(); // Optional: Print the table to check the final state
    }
}
