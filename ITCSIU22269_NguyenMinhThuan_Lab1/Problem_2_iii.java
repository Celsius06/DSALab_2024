// iii. Programming Projects 2.2 in Text-Book (lowArray.java)

public class Problem_2_iii {

    static class HighArray {
        private long[] a;  // ref to array a
        private int nElems; // number of data items

        //-----------------------------------------------------------
        public HighArray(int max) { // constructor
            a = new long[max]; // create the array
            nElems = 0;       // no items yet
        }

        //-----------------------------------------------------------
        public boolean find(long searchKey) { // find specified value
            for (int j = 0; j < nElems; j++) { // for each element,
                if (a[j] == searchKey) {   // found item?
                    return true;            // exit loop and return true
                }
            }
            return false;             // can't find it
        } // end find()

        //-----------------------------------------------------------
        public void insert(long value) { // put element into array
            a[nElems] = value; // insert it
            nElems++;           // increment size
        }

        //-----------------------------------------------------------
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

        //-----------------------------------------------------------
        public long removeMax() {
            if (nElems == 0) {
                throw new IllegalStateException("Array is empty");
            }
            long max = a[0];
            int maxIndex = 0;
            for (int i = 1; i < nElems; i++) {
                if (a[i] > max) {
                    max = a[i];
                    maxIndex = i;
                }
            }
            for (int i = maxIndex; i < nElems - 1; i++) {
                a[i] = a[i + 1];
            }
            nElems--;
            return max;
        }

        //-----------------------------------------------------------
        public void display() { // displays array contents
            for (int j = 0; j < nElems; j++) { // for each element,
                System.out.print(a[j] + " ");  // display it
            }
            System.out.println();
        } // end display()

    } // end class HighArray

    ////////////////////////////////////////////////////////////////

    static class HighArrayApp {
        public static void main(String[] args) {

            int maxSize = 100; // array size
            HighArray arr; // reference to array
            arr = new HighArray(maxSize); // create the array

            arr.insert(77); // insert 10 items
            arr.insert(99);
            arr.insert(44);
            arr.insert(55);
            arr.insert(22);
            arr.insert(88);
            arr.insert(11);
            arr.insert(00);
            arr.insert(66);
            arr.insert(33);

            arr.display(); // display items

            int searchKey = 35; // search for item
            if (arr.find(searchKey)) {
                System.out.println("Found " + searchKey);
            } else {
                System.out.println("Can't find " + searchKey);
            }

            long removedMax = arr.removeMax(); // remove and get the max value
            System.out.println("Removed max value: " + removedMax);

            arr.display(); // display items again
        } // end main()
    } // end class HighArrayApp

    //////////////////////////////////////////////////////////////
}


