package AdvancedSorting.Submit.Problem_6_3;

class ArraySh {
    long[] theArray; // ref to array theArray
    private int nElems; // number of data items
    private int comparisonCount; // counter for comparisons
    private int copyCount; // counter for copies
    private int swapCount; // counter for swaps

    public ArraySh(int max) // constructor
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

    public void shellSort() {
        int inner, outer;
        long temp;
        int h = 1; // find initial value of h
        while (h <= nElems / 3)
            h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
        while (h > 0) // decreasing h, until h=1
        {
            // h-sort the file
            for (outer = h; outer < nElems; outer++) {
                temp = theArray[outer];
                inner = outer;
                while (inner > h - 1 && theArray[inner - h] >= temp) {
                    theArray[inner] = theArray[inner - h];
                    inner -= h;
                    comparisonCount++; // increment comparison counter
                    copyCount++; // increment copy counter
                }
                theArray[inner] = temp;
                swapCount++; // increment swap counter
            } // end for
            h = (h - 1) / 3; // decrease h
        } // end while(h>0)
    } // end shellSort()

    public void resetCounters() {
        comparisonCount = 0;
        copyCount = 0;
        swapCount = 0;
    }

    public void displayCounters() {
        System.out.println("Number of comparisons: " + comparisonCount);
        System.out.println("Number of copies: " + copyCount);
        System.out.println("Number of swaps: " + swapCount);
    }
}

public class ShellSortApp {
    public static void main(String[] args) {
        int[] sizes = { 10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000 };
        for (int size : sizes) {
            ArraySh arr = new ArraySh(size);
            fillArrayWithRandomData(arr);
            System.out.println("Sorting array with " + size + " items:");
            arr.shellSort();
            arr.displayCounters();
            System.out.println();
        }
    }

    private static void fillArrayWithRandomData(ArraySh arr) {
        arr.resetCounters(); // reset counters before filling
        for (int i = 0; i < arr.theArray.length; i++) {
            long n = (int) (java.lang.Math.random() * 99);
            arr.insert(n);
        }
    }
}
