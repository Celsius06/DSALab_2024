public class Problem_2 {
    static class ArraySel 
    {
        private long[] a;                 // ref to array a
        private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArraySel(int max)          // constructor
      {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
        for(int j=0; j<nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
      }
//--------------------------------------------------------------
    public void selectionSort_Problem2() {
        int out, in, min;
        int totalComs = 0;  // Request 3

        for (out = 0; out < nElems - 1; out++) { // outer loop
            min = out; // initialize the minimum index to the current outer loop index
            for (in = out + 1; in < nElems; in++) { // inner loop
                totalComs++;
                if (a[in] < a[min]) { // if min greater,
                    min = in; // update the index of the minimum element
                }
            }
            swap(out, min); // swap them
            System.out.println("Swapped: " + a[out] + " and " + a[min]); // Request 2
            System.out.print("The inner array after swapping: ");
            display();
            System.out.println(" ");
        } // end for(out)

        System.out.println("Number of comparisons after inner loop: " + totalComs); // Request 3
        System.out.println("Total number of comparisons: " + totalComs); // Request 3
        System.out.println("Estimated complexity of the algorithm: O^(n^2) = " + ((long) nElems * (nElems - 1) / 2)); // Request 3
    } // end selectionSort()
//--------------------------------------------------------------
    private void swap(int one, int two)
      {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
      }
//--------------------------------------------------------------
   }  // end class ArraySel

    public static void main(String[] args)
      {
        int maxSize = 100;            // array size
        ArraySel arr;                 // reference to array
        arr = new ArraySel(maxSize);  // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        System.out.print("Initial array: ");
        arr.display();                // display items
        System.out.print("\n");

        arr.selectionSort_Problem2();          // bubble sort them
  
        System.out.print("Sorted array: ");
        arr.display();                // display them again
      }  // end main()
   }  // end class SelectSortApp
