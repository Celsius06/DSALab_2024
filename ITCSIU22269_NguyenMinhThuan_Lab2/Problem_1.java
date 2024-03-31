public class Problem_1 {
    class ArrayBub {
        private long[] a;
        private int nElems;
    
        public ArrayBub (int max) {
            a = new long[max];
            nElems = 0;
        }
     
        public void insert(long value) {
            a[nElems] = value;
            nElems++;
        }

        public void display() {
            for (int j = 0; j < nElems; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println(); 
        }

        public void bubbleSort_Problem1() {
            int out, in;
            int totalSwaps = 0;     // Request 2
            int totalComs = 0;      // Request 3

            System.out.print("Initial array: ");
            display();
            System.out.println();

            for (out = nElems - 1; out > 1; out--) {
                int nSwaps = 0;     // Request 2
                int nComs = 0;      // Request 3

                System.out.println("After " + (nElems - out) + " outer iteration:");
        
                for (in = 0; in < out; in++) {
                    nComs++;        // Request 3
                    if (a[in] > a[in + 1]) {
                        swap(in, in + 1);
                        nSwaps++;   // Request 2    
                    }
                }                
                                
            totalSwaps += nSwaps;
            totalComs += nComs;  

            display(); // Display the array after each outer iteration
            System.out.println("Number of inner loop swap(s): " + nSwaps);
            System.out.println("Number of inner loop comparison(s): " + nComs);
            System.out.println();
        }            
    
            System.out.println("Total number of comparisons: " + totalComs);                                                 // Request 3
            System.out.println("Total number of swaps: " + totalSwaps);                                                      // Request 2
            System.out.println("Estimated complexity of the algorithm: O^(n^2) = " + ((long) nElems * (nElems - 1) / 2));    // Request 3
            System.out.print("Sorted array: ");
        } 

        public void swap(int one, int two) {
            long temp = a[one];
            a[one] = a[two];
            a[two] = temp;
        }
    }

    public static void main(String[] args) {
        int maxSize = 100;             // array size
        ArrayBub arr;                  // reference to array
        Problem_1 problem = new Problem_1();
        arr = problem.new ArrayBub(maxSize);  // create the array

        arr.insert(77);                // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);

        arr.bubbleSort_Problem1();     // bubble sort them
        arr.display();                 // display them again
    }  // end main()
}
