import java.util.Random;

public class Problem_4 {
    static class Array {
        private long[] a;
        private int nElems;

        public Array (int max) {
            a = new long[max];
            nElems = 0;
        }

        public void insert(long value) {
            a[nElems] = value;
            nElems++;
        }

        public void display() {
            for (int j = 0; j < nElems; j++)
                System.out.print(a[j] + " ");
            System.out.println("");
        }

        public void swap(int one, int two) {
            long temp = a[one];
            a[one] = a[two];
            a[two] = temp;
        }

        public void bubbleSort_Problem1() {
            int out, in;
            int totalSwaps = 0;
            int totalComs = 0;

            for (out = nElems - 1; out > 1; out--) {
                int nSwaps = 0;
                int nComs = 0;

                for (in = 0; in < out; in++) {
                    nComs++;
                    if (a[in] > a[in + 1]) {
                        swap(in, in + 1);
                        nSwaps++;
                    }
                }

                totalSwaps += nSwaps;
                totalComs += nComs;
            }

            System.out.println("Bubble Sort: Total number of comparisons: " + totalComs);
            System.out.println("Bubble Sort: Total number of swaps: " + totalSwaps);
        }

        public void selectionSort_Problem2() {
            int out, in, min;
            int totalComs = 0;
            int totalSwaps = 0;
        
            for (out = 0; out < nElems - 1; out++) {
                min = out;
                for (in = out + 1; in < nElems; in++) {
                    totalComs++;
                    if (a[in] < a[min]) {
                        min = in;
                    }
                }
                swap(out, min);
                totalSwaps++; // Increment totalSwaps after each swap
            }
        
            System.out.println("Selection Sort: Number of comparisons after inner loop: " + totalComs);
            System.out.println("Selection Sort: Total number of swaps: " + totalSwaps);
        }        

        public void insertionSort_Problem3() {
            int in, out;
            int totalComparisons = 0;
            int totalSwaps = 0;
        
            for (out = 1; out < nElems; out++) { // out is dividing line
                long temp = a[out];  // remove marked item
                in = out;  // start shifts at out
                while (in > 0 && a[in - 1] >= temp) { // until one is smaller,
                    a[in] = a[in - 1];  // shift item to the right
                    --in;  // go left one position
                    totalComparisons++; // increment comparison counter
                    totalSwaps++; // increment swap counter
                }
                a[in] = temp;  // insert marked item
            }  // end for
        
            System.out.println("Total number of comparisons: " + totalComparisons);
            System.out.println("Total number of swaps: " + totalSwaps);
        }  // end insertionSort()
        
    }

    public static void main(String[] args) {
        Array arr;
        Random rd = new Random();
        int []a;

        System.out.println();

        for (int i = 10000; i <= 50000; i += 5000) {
            a = new int[i];
            arr = new Array(i);
            for (int j = 0; j < i; j++) {
                a[j] = rd.nextInt(i);
                arr.insert(a[j]);
            }

            // Uncomment the sort method you want to test
            // arr.bubbleSort_Problem1();
            // for (int j = 0; j < i; j++) {
            //     arr.a[j] = a[j];
            // }

            // arr.selectionSort_Problem2();
            // for (int j = 0; j < i; j++) {
            //     arr.a[j] = a[j];
            // }

            arr.insertionSort_Problem3();
            for (int j = 0; j < i; j++) {
                arr.a[j] = a[j];
            }
        }
    }
}
