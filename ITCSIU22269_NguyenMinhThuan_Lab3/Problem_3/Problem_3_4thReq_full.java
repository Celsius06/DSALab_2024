package Problem_3;

public class Problem_3_4thReq_full {
    static class Queue {
        private int maxSize;
        private long[] queArray;
        private int front;
        private int rear;
        private int nItems;
        //--------------------------------------------------------------
        public Queue(int s)          // constructor
        {
            maxSize = s;
            queArray = new long[maxSize];
            front = 0;
            rear = -1;
            nItems = 0;
        }
        //--------------------------------------------------------------
        public void insert(long j)   // put item at rear of queue
        {
            if (isFull()) {
                System.out.println("Queue is full. Cannot insert " + j);
                return;
            }
            if(rear == maxSize - 1)         // deal with wraparound
                rear = -1;
            queArray[++rear] = j;         // increment rear and insert
            nItems++;                     // one more item
        }
        //--------------------------------------------------------------
        public long remove()         // take item from front of queue
        {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1; // Return a special value (-1) to indicate an empty queue
            }
            long temp = queArray[front++]; // get value and incr front
            if(front == maxSize)           // deal with wraparound
                front = 0;
            nItems--;                      // one less item
            return temp;
        }
        //--------------------------------------------------------------
        public long peekFront()      // peek at front of queue
        {
            return queArray[front];
        }
        //--------------------------------------------------------------
        public boolean isEmpty()    // true if queue is empty
        {
            return (nItems == 0);
        }
        //--------------------------------------------------------------
        public boolean isFull()     // true if queue is full
        {
            return (nItems == maxSize);
        }
        //--------------------------------------------------------------
        public int size()           // number of items in queue
        {
            return nItems;
        }
        //--------------------------------------------------------------

        // Display the array, the queue, and the front and rear indices
        public void displayAll() {
            System.out.print("Array: ");
            for (int i = 0; i < maxSize; i++) {
                System.out.print(queArray[i] + " ");
            }
            System.out.println();

            if (!isEmpty()) { // Check if the queue is not empty before printing the queue line
                System.out.print("Queue: ");
                int tempFront = front;
                for (int i = 0; i < nItems; i++) {
                    System.out.print(queArray[tempFront] + " ");
                    tempFront = (tempFront + 1) % maxSize;
                }
            } else {
                System.out.print("Queue: empty"); // Print "empty" if the queue is empty
            }
            System.out.println("\n[Array] Front indice: " + front + "; " + "Rear indice: " + rear);
            System.out.println(); // Add an extra line break after each iteration
        }
    }   // end class Queue
    ////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Queue theQueue = new Queue(5);  // queue holds 5 items

        theQueue.insert(10);            // insert 4 items
        theQueue.insert(20);
        theQueue.insert(30);

        theQueue.displayAll();

        theQueue.remove();              // remove 2 items
        theQueue.remove();              //    (10, 20)

        theQueue.displayAll();

        theQueue.insert(40);            // insert 3 more items
        theQueue.insert(50);            //    (wraps around)
        theQueue.insert(60);

        theQueue.insert(70);
        theQueue.insert(80);

        theQueue.displayAll();

        System.out.print("Removed numbers from the queue: ");
        for (int i = 0; i < 4; i++) {
            long n = theQueue.remove();
            // check if the removal is successful
            if (n != -1) {
                System.out.print(n + " ");
            }
        }

        System.out.println();
        theQueue.displayAll();
    }  // end main()
}
