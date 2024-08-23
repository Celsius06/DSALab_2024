package Answer.Table;

import java.io.*;

////////////////////////////////////////////////////////////////

class HashTableApp {
    public static void main(String[] args) throws IOException {
        DataItem aDataItem;
        int aKey, size, n, keysPerCell;
        // get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keysPerCell = 10;
        // make table
        HashTable theHashTable = new HashTable(size);
        int[] initialKeys = new int[n]; // Display the key sequence for the initial filling of the table
        int totalProbes = 0; // Display the average probe length for the initial filling of the table

        for (int j = 0; j < n; j++) // insert data
        {
            aKey = (int) (java.lang.Math.random() * keysPerCell * size);
            initialKeys[j] = aKey; // Display the key sequence for the initial filling of the table
            aDataItem = new DataItem(aKey);
            int probesForInsert = theHashTable.insert(aDataItem); // Display the average probe length for the initial
                                                                  // filling of the table
            totalProbes += probesForInsert; // Display the average probe length for the initial filling of the table
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

        while (true) // interact with user
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, find, or quit: ");
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
            } // end switch
        } // end while
    } // end main()
      // --------------------------------------------------------------

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    // --------------------------------------------------------------
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    // -------------------------------------------------------------
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    // --------------------------------------------------------------
} // end class HashTableApp
  ////////////////////////////////////////////////////////////////

class DataItem { // (could have more data)
    private int iData; // data item (key)
    // --------------------------------------------------------------

    public DataItem(int ii) // constructor
    {
        iData = ii;
    }

    // --------------------------------------------------------------
    public int getKey() {
        return iData;
    }
    // --------------------------------------------------------------
} // end class DataItem
  ////////////////////////////////////////////////////////////////

class HashTable {
    private DataItem[] hashArray; // array holds hash table
    private int arraySize;
    private DataItem nonItem; // for deleted items
    // -------------------------------------------------------------

    public HashTable(int size) // constructor
    {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1); // deleted item key is -1
    }

    // -------------------------------------------------------------
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

    // -------------------------------------------------------------
    public int hashFunc(int key) {
        return key % arraySize; // hash function
    }

    // -------------------------------------------------------------
    public int insert(DataItem item) { // insert a DataItem
        // assume table not full
        int key = item.getKey(); // extract key
        int hashVal = hashFunc(key); // hash the key

        // Display the hash value and the probe sequence for insert and find
        System.out.print("Hash value: " + hashVal + " | Probe sequence: " + hashVal);

        // Display the probe length for each find and insert
        int probeCount = 1;

        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            // Implement quadratic probing and compare the average probe length
            hashVal = (hashVal + probeCount * probeCount) % arraySize;

            System.out.print(" -> " + hashVal);
            probeCount++; // Increment probe count
        }

        // Display the probe length for each find and insert
        System.out.println(" | Probe length: " + probeCount);

        hashArray[hashVal] = item; // insert item
        return probeCount; // Return probe count
    } // end insert()
      // -------------------------------------------------------------

    public DataItem delete(int key) // delete a DataItem
    {
        int hashVal = hashFunc(key); // hash the key

        while (hashArray[hashVal] != null) // until empty cell,
        { // found the key?
            if (hashArray[hashVal].getKey() == key) {
                DataItem temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem; // delete item
                return temp; // return item
            }
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }
        return null; // can't find item
    } // end delete()
      // -------------------------------------------------------------

    public DataItem find(int key) // find item with key
    {
        int hashVal = hashFunc(key); // hash the key

        // Display the hash value and the probe sequence for insert and find
        System.out.print("Hash value: " + hashVal + " | Probe sequence: " + hashVal);

        // Display the probe length for each find and insert
        int probeCount = 1;

        while (hashArray[hashVal] != null) // until empty cell,
        { // found the key?
            if (hashArray[hashVal].getKey() == key) {
                System.out.println();
                return hashArray[hashVal]; // yes, return item
            }

            // Implement quadratic probing and compare the average probe length
            // Instead of linearly probing (i.e., moving to the next index)
            hashVal = (hashVal + probeCount * probeCount) % arraySize;

            // hashVal %= arraySize; // wraparound if necessary
            System.out.print(" -> " + hashVal);
            probeCount++; // Increment probe count
        }

        // Display the probe length for each find and insert
        System.out.println(" | Probe length: " + probeCount);

        return null; // can't find item
    }
    // -------------------------------------------------------------
} // end class HashTable
  ////////////////////////////////////////////////////////////////
