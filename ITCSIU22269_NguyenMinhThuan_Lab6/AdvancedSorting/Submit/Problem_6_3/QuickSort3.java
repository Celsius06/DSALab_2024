package AdvancedSorting.Submit.Problem_6_3;

public class QuickSort3 {
    public static void main(String[] args) {
        int[] sizes = { 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000 };

        for (int size : sizes) {
            ArrayIns3 arr = new ArrayIns3(size); // create the array

            // Fill array with random numbers
            for (int j = 0; j < size; j++) {
                long n = (int) (java.lang.Math.random() * 99);
                arr.insert(n);
            }

            System.out.println("Array size: " + size);
            arr.quickSort(); // quicksort the array
            System.out.println();
        }
    }

    static class ArrayIns3 {
        private long[] theArray; // ref to array theArray
        private int nElems; // number of data items
        private int comparisonCount; // counter for comparisons
        private int copyCount; // counter for copies
        private int swapCount; // counter for swaps

        public ArrayIns3(int max) // constructor
        {
            theArray = new long[max]; // create the array
            nElems = 0; // no items yet
            comparisonCount = 0; // initialize comparison counter
            copyCount = 0; // initialize copy counter
            swapCount = 0; // initialize swap counter
        }

        public void insert(long value) // put element into array
        {
            theArray[nElems] = value; // insert it
            nElems++; // increment size
        }

        public void display() // displays array contents
        {
            System.out.print("A = ");
            for (int j = 0; j < nElems; j++) // for each element,
                System.out.print(theArray[j] + " "); // display it
            System.out.println("");
        }

        public void quickSort() {
            comparisonCount = 0;
            copyCount = 0;
            swapCount = 0;
            recQuickSort(0, nElems - 1);
            System.out.println("Number of comparisons: " + comparisonCount);
            System.out.println("Number of copies: " + copyCount);
            System.out.println("Number of swaps: " + swapCount);
        }

        public void recQuickSort(int left, int right) {
            int size = right - left + 1;
            if (size < 10) // insertion sort if small
                insertionSort(left, right);
            else // quicksort if large
            {
                long median = medianOf3(left, right);
                int partition = partitionIt(left, right, median);
                recQuickSort(left, partition - 1);
                recQuickSort(partition + 1, right);
            }
        } // end recQuickSort()

        public long medianOf3(int left, int right) {
            int center = (left + right) / 2;
            // order left & center
            if (theArray[left] > theArray[center])
                swap(left, center);
            // order left & right
            if (theArray[left] > theArray[right])
                swap(left, right);
            // order center & right
            if (theArray[center] > theArray[right])
                swap(center, right);

            swap(center, right - 1); // put pivot on right
            return theArray[right - 1]; // return median value
        } // end medianOf3()

        public void swap(int dex1, int dex2) // swap two elements
        {
            long temp = theArray[dex1]; // A into temp
            theArray[dex1] = theArray[dex2]; // B into A
            theArray[dex2] = temp; // temp into B
            swapCount++;
        } // end swap()

        public int partitionIt(int left, int right, long pivot) {
            int leftPtr = left; // right of first elem
            int rightPtr = right - 1; // left of pivot
            while (true) {
                while (theArray[++leftPtr] < pivot) // find bigger
                    comparisonCount++;
                while (theArray[--rightPtr] > pivot) // find smaller
                    comparisonCount++;
                if (leftPtr >= rightPtr) // if pointers cross,
                    break; // partition done
                else // not crossed, so
                    swap(leftPtr, rightPtr); // swap elements
            } // end while(true)
            swap(leftPtr, right - 1); // restore pivot
            return leftPtr; // return pivot location
        } // end partitionIt()

        // insertion sort
        public void insertionSort(int left, int right) {
            int in, out;
            // sorted on left of out
            for (out = left + 1; out <= right; out++) {
                long temp = theArray[out]; // remove marked item
                in = out; // start shifts at out
                while (in > left && theArray[in - 1] >= temp) {
                    theArray[in] = theArray[in - 1]; // shift item to right
                    --in; // go left one position
                    comparisonCount++;
                    copyCount++;
                }
                theArray[in] = temp; // insert marked item
                copyCount++;
            } // end for
        } // end insertionSort()
    } // end class ArrayIns
} // end class QuickSort3
