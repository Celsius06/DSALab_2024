// ii. Programming Projects 2.1 in Text-Book (array.java)

// import java.io.File;
// import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Problem_2_ii {
    static class HighArray {
        private long[] a;  // ref to array a
        private int nElems; // number of data items

        public HighArray(int max) { // constructor
            a = new long[max]; // create the array
            nElems = 0;       // no items yet
        }

        public boolean find(long searchKey) { // find specified value
            int j;
            for (j = 0; j < nElems; j++) { // for each element,
                if (a[j] == searchKey) {   // found item?
                    break;                  // exit loop before end
                }
            }
            if (j == nElems) {         // gone to end?
                return false;             // yes, can't find it
            } else {
                return true;              // no, found it
            }
        } // end find()

        public void insert(long value) { // put element into array
            a[nElems] = value; // insert it
            nElems++;           // increment size
        }

        public boolean delete(long value) {
            int j;
            for (j = 0; j < nElems; j++) { // look for it
                if (value == a[j]) {
                    break;
                }
            }
            if (j == nElems) { // can't find it
                return false;
            } else { // found it
                for (int k = j; k < nElems - 1; k++) { // move higher ones down
                    a[k] = a[k + 1];
                }
                nElems--; // decrement size
                return true;
            }
        } // end delete()

        public void display() { // displays array contents
            for (int j = 0; j < nElems; j++) { // for each element,
                System.out.print(a[j] + " ");  // display it
            }
            System.out.println();
        } // end display()

        public long getMax() { // returns the value of the highest key in the array, or -1 if the array is empty
            if (nElems == 0) {
                return -1; // array is empty
            }

            long max = a[0];
            int maxIndex = 0;
            for (int j = 1; j < nElems; j++) {
                if (a[j] > max) {
                    max = a[j];
                    maxIndex = j;
                }
            }
            // Remove max element
            delete(maxIndex);
            return max;
        } // end getMax()

        public void removeMax() {
            getMax(); // Removing max element without needing to use its value
        }
    } // end class HighArray

    static class HighArrayApp {
        public static void main(String[] args) {
            HighArray arr;
            int maxSize = 100; // array size
            arr = new HighArray(maxSize); // create the array

            // Fill the array with random numbers
            Random random = new Random();
            for (int i = 0; i < maxSize; i++) {
                arr.insert(random.nextInt(100)); // Generate random numbers in range [0, 99]
            }

            arr.display(); // display items

            // Read the item to find from user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the item to find: ");
            int searchKey = scanner.nextInt();

            // Search for the item
            if (arr.find(searchKey)) {
                System.out.println("Found " + searchKey);
            } else {
                System.out.println("Can't find " + searchKey);
            }

            // Remove a random item
            int randomIndex = random.nextInt(maxSize);
            long randomValue = arr.a[randomIndex];
            int comparisonsBeforeDelete = arr.nElems; // Number of comparisons before delete operation
            arr.delete(randomValue);
            int comparisonsAfterDelete = arr.nElems; // Number of comparisons after delete operation
            int memoryMoves = comparisonsBeforeDelete - comparisonsAfterDelete; // Number of memory moves

            arr.display(); // display items again

            long max = arr.getMax();
            if (max != -1) {
                System.out.println("Max value in the array: " + max);
            } else {
                System.out.println("The array is empty.");
            }

            System.out.println("Number of comparisons to find an item: " + (maxSize - comparisonsBeforeDelete));
            System.out.println("Number of memory moves to delete an item: " + memoryMoves);

            scanner.close();

        } // end main()
    } // end class HighArrayApp
}
