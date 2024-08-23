// hashChain.java
// demonstrates hash table with separate chaining
// to run this program: C:>java HashChainApp

package Answer.Chain;

import java.io.*;

////////////////////////////////////////////////////////////////
class HashChainApp {
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

        int[] initialKeys = new int[n]; // Display the key sequence for the initial filling of the table

        int totalProbes = 0; // Display the average probe length for the initial filling of the table

        for (int j = 0; j < n; j++) // insert data
        {
            aKey = (int) (java.lang.Math.random() * keysPerCell * size);
            initialKeys[j] = aKey; // Display the key sequence for the initial filling of the table
            aDataItem = new Link(aKey);

            // Display the average probe length for the initial filling of the table
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

        while (true) // interact with user
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, find or quit: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Link(aKey);
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
                    if (aDataItem != null)
                        System.out.println("Found " + aKey);
                    else
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

    // -------------------------------------------------------------
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
} // end class HashChainApp
  ////////////////////////////////////////////////////////////////

class Link { // (could be other items)
    private int iData; // data item
    public Link next; // next link in list
    // -------------------------------------------------------------

    public Link(int it) // constructor
    {
        iData = it;
    }

    // -------------------------------------------------------------
    public int getKey() {
        return iData;
    }

    // -------------------------------------------------------------
    public void displayLink() // display this link
    {
        System.out.print(iData + " ");
    }
} // end class Link
  ////////////////////////////////////////////////////////////////

class SortedList {
    Link first; // ref to first list item
    // -------------------------------------------------------------

    public void SortedList() // constructor
    {
        first = null;
    }

    // -------------------------------------------------------------
    public int insert(Link theLink) // insert link, in order
    {
        int key = theLink.getKey();
        Link previous = null; // start at first
        Link current = first;
        int comparisons = 0; // Display the probe length for each find and insert
        // until end of list,
        while (current != null && key > current.getKey()) { // or current > key,
            previous = current;
            current = current.next; // go to next item
            comparisons++;
        }
        if (previous == null) // if beginning of list,
            first = theLink; // first --> new link
        else // not at beginning,
            previous.next = theLink; // prev --> new link
        theLink.next = current; // new link --> current
        comparisons++;

        return comparisons;
    } // end insert()
      // -------------------------------------------------------------

    public int delete(int key) // delete link
    { // (assumes non-empty list)
        Link previous = null; // start at first
        Link current = first;
        int comparisons = 0; // Display the probe length for each find and insert
        // until end of list,
        while (current != null && key != current.getKey()) { // or key == current,
            previous = current;
            current = current.next; // go to next link
            comparisons++;
        }
        // disconnect link
        if (previous == null) { // if beginning of list
            first = first.next; // delete first link
            comparisons++;
        } else { // not at beginning
            previous.next = current.next; // delete current link
            comparisons++;
        }
        return comparisons;
    } // end delete()
      // -------------------------------------------------------------

    public Link find(int key) // find link
    {
        Link current = first; // start at first
        int comparisons = 0; // Display the probe length for each find and insert
        // until end of list,
        while (current != null && current.getKey() <= key) { // or key too small,
            if (current.getKey() == key) { // is this the link?
                comparisons++;
                System.out.println(" | Probe length: " + comparisons); // Display the probe length for each find and
                                                                       // insert
                return current; // found it, return link
            }
            current = current.next; // go to next item
            comparisons++;
        }
        System.out.println(" | Probe length: " + comparisons); // Display the probe length for each find and insert
        return null; // didn't find it
    } // end find()
      // -------------------------------------------------------------

    public void displayList() {
        System.out.print("List (first --> last): ");
        Link current = first; // start at beginning of list
        while (current != null) // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }
} // end class SortedList
  ////////////////////////////////////////////////////////////////

class HashTable {
    private SortedList[] hashArray; // array of lists
    private int arraySize;

    // -------------------------------------------------------------
    public HashTable(int size) // constructor
    {
        arraySize = size;
        hashArray = new SortedList[arraySize]; // create array
        for (int j = 0; j < arraySize; j++) // fill array
            hashArray[j] = new SortedList(); // with lists
    }

    // -------------------------------------------------------------
    public void displayTable() {
        for (int j = 0; j < arraySize; j++) // for each cell,
        {
            System.out.print(j + ". "); // display cell number
            hashArray[j].displayList(); // display list
        }
    }

    // -------------------------------------------------------------
    public int hashFunc(int key) // hash function
    {
        return key % arraySize;
    }

    // -------------------------------------------------------------
    // Display the probe length for each find and insert
    // public int insert(Link theLink) // insert a link
    // {
    //     int key = theLink.getKey();
    //     int hashVal = hashFunc(key); // hash the key
    //     int comparisons = hashArray[hashVal].insert(theLink); // insert at hashVal
    //     System.out.println("Inserted key: " + key + " with probe length: " + comparisons);                                                                                   
    //     return comparisons;
    // } // end insert()
    //   // -------------------------------------------------------------

    // -------------------------------------------------------------
    // Display the average probe length for the initial filling of the table
    public int insert(Link theLink) // insert a link
    {
        int key = theLink.getKey();
        int hashVal = hashFunc(key); // hash the key
        int probeLength = hashArray[hashVal].insert(theLink); 
        return probeLength; 
    } // end insert()
      // -------------------------------------------------------------

    public void delete(int key) // delete a link
    {
        int hashVal = hashFunc(key); // hash the key
        int comparisons = hashArray[hashVal].delete(key); // delete link
        System.out.println("Deleted key: " + key + " with probe length: " + comparisons); // Display the probe length
                                                                                          // for each find and insert
    } // end delete()
      // -------------------------------------------------------------

    public Link find(int key) // find link
    {
        int hashVal = hashFunc(key); // hash the key
        Link current = hashArray[hashVal].first; // start at the correct chain

        // Display the hash value and the probe sequence for find
        System.out.print("Hash value: " + hashVal + " | Probe sequence: " + hashVal);

        int probeCount = 1;

        while (current != null) // until end of list
        {
            if (current.getKey() == key) // is this the link?
            {
                System.out.println(" | Probe length: " + probeCount);
                return current; // found it, return link
            }
            current = current.next; // move to next link
            probeCount++;
            System.out.print(" -> " + hashVal);
        }

        System.out.println(" | Probe length: " + probeCount);
        return null; // didn't find it
    }
    // -------------------------------------------------------------
} // end class HashTable
  ////////////////////////////////////////////////////////////////
