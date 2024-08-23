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
    @SuppressWarnings("unchecked") // Remove the undesired warning for this line:
                                   // "table = new LinkedList[TABLE_SIZE];"
    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int hash(int key) {
        return key % TABLE_SIZE;
    }

    // 1. Insert a key-value pair
    public void insert(int key, String value) {
        int hashIndex = hash(key);
        LinkedList<Entry> entries = table[hashIndex];

        // Check that key for existence and update its value if it exists
        for (Entry entry : entries) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        // If that key doesn't exist, then we add new entry
        entries.add(new Entry(key, value));
    }

    // 2. Delete a key
    public void delete(int key) {
        int hashIndex = hash(key);
        LinkedList<Entry> entries = table[hashIndex];

        // We find the entry with the specified key and remove it
        for (Entry entry : entries) {
            if (entry.key == key) {
                entries.remove(entry);
                return;
            }
        }
    }

    // 3. Retrieve a value by key
    public String get(int key) {
        int hashIndex = hash(key);
        LinkedList<Entry> entries = table[hashIndex];

        // We find the entry with the specified key and return its value
        for (Entry entry : entries) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        // If that entry is not found, then we return null
        return null;
    }

    // Helper method to print the table (optional)
    public void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry entry : table[i]) {
                System.out.print("[Entry key: " + entry.key + " | " + "Entry value: " + entry.value + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.insert(1, "One");
        hashTable.insert(2, "Two");
        hashTable.insert(3, "Three");
        hashTable.delete(2);

        // This part is just for further testing purposes
        hashTable.insert(4, "Four");
        hashTable.insert(5, "Five");
        hashTable.insert(6, "Six");
        hashTable.insert(7, "Seven");
        hashTable.insert(8, "Eight");
        hashTable.insert(9, "Nine");
        hashTable.delete(9);
        hashTable.delete(7);
        hashTable.delete(5);
        hashTable.delete(8);
        hashTable.delete(6);
        hashTable.delete(4);

        String value = hashTable.get(1); // should return "One"
        String missingValue = hashTable.get(2); // should return null

        System.out.println("Value for key 1: " + value); // Output: One
        System.out.println("Value for key 2: " + missingValue); // Output: null

        System.out.println(); // Line breaking
        System.out.println("Hash Table (final state): ");
        hashTable.printTable(); // Optional: Print the table to check the final state
    }
}
