package AdvancedSorting.Submit.Problem_6_3;

import java.util.Random;

public class MergeSort {

    static class DArray {
        private long[] theArray; // ref to array theArray
        private int nElems; // number of data items
        private int comparisonCount; // counter for comparisons
        private int copyCount; // counter for copies
        private int swapCount; // counter for swaps

        public DArray(int max) // constructor
        {
            theArray = new long[max]; // create array
            nElems = 0;
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
            for (int j = 0; j < nElems; j++) // for each element,
                System.out.print(theArray[j] + " "); // display it
            System.out.println("");
        }

        public void mergeSort() // called by main()
        { // provides workspace
            long[] workSpace = new long[nElems];
            recMergeSort(workSpace, 0, nElems - 1);
        }

        private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {
            if (lowerBound == upperBound) // if range is 1,
                return; // no use sorting
            else { // find midpoint
                int mid = (lowerBound + upperBound) / 2;
                // sort low half
                recMergeSort(workSpace, lowerBound, mid);
                // sort high half
                recMergeSort(workSpace, mid + 1, upperBound);
                // merge them
                merge(workSpace, lowerBound, mid + 1, upperBound);
            } // end else
        } // end recMergeSort()

        private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound) {
            int j = 0; // workspace index
            int lowerBound = lowPtr;
            int mid = highPtr - 1;
            int n = upperBound - lowerBound + 1; // # of items

            while (lowPtr <= mid && highPtr <= upperBound) {
                comparisonCount++; // increment comparison counter
                if (theArray[lowPtr] < theArray[highPtr]) {
                    workSpace[j++] = theArray[lowPtr++];
                } else {
                    workSpace[j++] = theArray[highPtr++];
                }
            }

            while (lowPtr <= mid) {
                workSpace[j++] = theArray[lowPtr++];
            }

            while (highPtr <= upperBound) {
                workSpace[j++] = theArray[highPtr++];
            }

            for (j = 0; j < n; j++) {
                theArray[lowerBound + j] = workSpace[j];
                copyCount++; // increment copy counter
            }
            swapCount += n; // increment swap counter by the number of elements copied
        } // end merge()

        public void displayCounters() {
            System.out.println("Number of comparisons: " + comparisonCount);
            System.out.println("Number of copies: " + copyCount);
            System.out.println("Number of swaps: " + swapCount);
        }
    } // end class DArray

    public static void main(String[] args) {
        int[] sizes = { 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000 };
        Random rand = new Random();

        for (int size : sizes) {
            DArray arr = new DArray(size);
            System.out.println("Array size: " + size);

            for (int i = 0; i < size; i++) {
                arr.insert(rand.nextInt());
            }

            arr.mergeSort();
            arr.displayCounters();
            System.out.println();
        } // end for loop
    } // end main()
} // end class MergeSort()