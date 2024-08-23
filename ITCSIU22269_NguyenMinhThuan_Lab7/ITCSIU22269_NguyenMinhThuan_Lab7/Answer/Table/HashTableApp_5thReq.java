// This class acts as a test class that satisfys the 5th requirement: "Investigate how the load factor affects the average probe length"

package Answer.Table;

import java.io.*;

public class HashTableApp_5thReq {
    public static void main(String[] args) throws IOException {
        int size, keysPerCell = 10;
        System.out.print("Enter size of hash table: ");
        size = getInt();

        // Experiment with different load factors
        double[] loadFactors = { 0.1, 0.25, 0.5, 0.75, 0.9 };
        for (double loadFactor : loadFactors) {
            int n = (int) (size * loadFactor);
            HashTable theHashTable = new HashTable(size);
            int[] initialKeys = new int[n];
            int totalProbes = 0;

            for (int j = 0; j < n; j++) {
                int aKey = (int) (Math.random() * keysPerCell * size);
                initialKeys[j] = aKey;
                DataItem aDataItem = new DataItem(aKey);
                int probesForInsert = theHashTable.insert(aDataItem);
                totalProbes += probesForInsert;
            }

            double averageProbes = (double) totalProbes / n;
            System.out.println("Load factor: " + loadFactor + " | Average probe length: " + averageProbes);
        }

        // Allow user interaction after experiments
        interact(size);
    }

    private static void interact(int size) throws IOException {
        DataItem aDataItem;
        int aKey;
        HashTable theHashTable = new HashTable(size);
        while (true) {
            System.out.print("Enter first letter of show, insert, delete, find, or quit: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new DataItem(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    theHashTable.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Found " + aKey);
                    } else
                        System.out.println("Could not find " + aKey);
                    break;
                case 'q':
                    System.out.println("Quitted.");
                    return;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}

class DataItem {
    private int iData;

    public DataItem(int ii) {
        iData = ii;
    }

    public int getKey() {
        return iData;
    }
}

class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void displayTable() {
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public int insert(DataItem item) {
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int probeCount = 1;

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
            probeCount++;
        }
        hashArray[hashVal] = item;
        return probeCount;
    }

    public DataItem delete(int key) {
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItem find(int key) {
        int hashVal = hashFunc(key);
        int probeCount = 1;

        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                System.out.println(" | Probe length: " + probeCount);
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
            probeCount++;
        }
        System.out.println(" | Probe length: " + probeCount);
        return null;
    }
}
