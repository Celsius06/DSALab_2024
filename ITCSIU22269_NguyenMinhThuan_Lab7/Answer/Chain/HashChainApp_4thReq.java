// This class acts as a test class that satisfys the 4th requirement: "Investigate how the load factor affects the average probe length"

package Answer.Chain;

import java.io.*;

public class HashChainApp_4thReq {

    public static void main(String[] args) throws IOException {
        int aKey;
        Link aDataItem;
        int size, n, keysPerCell = 100;

        // get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();

        // make table
        HashTable theHashTable = new HashTable(size);

        int[] initialKeys = new int[n];
        int totalProbes = 0;

        // insert data
        for (int j = 0; j < n; j++) {
            aKey = (int) (java.lang.Math.random() * keysPerCell * size);
            initialKeys[j] = aKey;
            aDataItem = new Link(aKey);
            int probes = theHashTable.insert(aDataItem);
            totalProbes += probes;
            System.out.println("Inserted key: " + aKey + " with probe length: " + probes);
        }

        // Display the key sequence for the initial filling of the table
        System.out.print("Initial keys: ");
        for (int j = 0; j < n; j++) {
            System.out.print(initialKeys[j] + " ");
        }
        System.out.println();

        // Display the average probe length for the initial filling of the table
        double averageProbes = (double) totalProbes / n;
        System.out.println("Average probe length for initial filling: " + averageProbes);
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
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

class Link {
    private int iData;
    public Link next;

    public Link(int it) {
        iData = it;
    }

    public int getKey() {
        return iData;
    }

    public void displayLink() {
        System.out.print(iData + " ");
    }
}

class SortedList {
    Link first;

    public void SortedList() {
        first = null;
    }

    public int insert(Link theLink) {
        int key = theLink.getKey();
        Link previous = null;
        Link current = first;
        int comparisons = 0;
        while (current != null && key > current.getKey()) {
            previous = current;
            current = current.next;
            comparisons++;
        }
        if (previous == null)
            first = theLink;
        else
            previous.next = theLink;
        theLink.next = current;
        comparisons++;
        return comparisons;
    }

    public int delete(int key) {
        Link previous = null;
        Link current = first;
        int comparisons = 0;
        while (current != null && key != current.getKey()) {
            previous = current;
            current = current.next;
            comparisons++;
        }
        if (previous == null) {
            first = first.next;
            comparisons++;
        } else {
            previous.next = current.next;
            comparisons++;
        }
        return comparisons;
    }

    public Link find(int key) {
        Link current = first;
        int comparisons = 0;
        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                comparisons++;
                System.out.println(" | Probe length: " + comparisons);
                return current;
            }
            current = current.next;
            comparisons++;
        }
        System.out.println(" | Probe length: " + comparisons);
        return null;
    }

    public void displayList() {
        System.out.print("List (first --> last): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class HashTable {
    private SortedList[] hashArray;
    private int arraySize;

    public HashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int j = 0; j < arraySize; j++)
            hashArray[j] = new SortedList();
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }

    public int hashFunc(int key) {
        return key % arraySize;
    }

    public int insert(Link theLink) {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        int probeLength = hashArray[hashVal].insert(theLink);
        return probeLength;
    }

    public void delete(int key) {
        int hashVal = hashFunc(key);
        int comparisons = hashArray[hashVal].delete(key);
        System.out.println("Deleted key: " + key + " with probe length: " + comparisons);
    }

    public Link find(int key) {
        int hashVal = hashFunc(key);
        Link current = hashArray[hashVal].first;
        System.out.print("Hash value: " + hashVal + " | Probe sequence: " + hashVal);
        int probeCount = 1;
        while (current != null) {
            if (current.getKey() == key) {
                System.out.println(" | Probe length: " + probeCount);
                return current;
            }
            current = current.next;
            probeCount++;
            System.out.print(" -> " + hashVal);
        }
        System.out.println(" | Probe length: " + probeCount);
        return null;
    }
}
