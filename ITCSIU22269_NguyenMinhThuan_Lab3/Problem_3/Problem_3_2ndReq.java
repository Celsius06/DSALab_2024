package Problem_3;

public class Problem_3_2ndReq {
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
            if(rear == maxSize - 1)         // deal with wraparound
                rear = -1;
            queArray[++rear] = j;         // increment rear and insert
            nItems++;                     // one more item
        }
        //--------------------------------------------------------------
        public long remove()         // take item from front of queue
        {
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

        // Method to display the queue (loop from 1 to nItems and use a temporary front for wraparound)
        public void displayQueue() {
            int tempFront = front;
            System.out.print("Queue: ");
            for (int i = 0; i < nItems; i++) {
                System.out.print(queArray[tempFront]+ " ");
                tempFront++;
                // Wraparound
                if (tempFront == maxSize) {
                    tempFront = 0;
                }
            }
            System.out.println();
        }
        //--------------------------------------------------------------
    }   // end class Queue
    ////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        Queue theQueue = new Queue(5);  // queue holds 5 items
    
        theQueue.insert(10);            // insert 4 items
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
    
        theQueue.remove();              // remove 3 items (10, 20, 30)
        theQueue.remove();
        theQueue.remove();
    
        theQueue.insert(50);            // insert 4 more items (wraps around)
        theQueue.insert(60);
        theQueue.insert(70);
        theQueue.insert(80);
    
        theQueue.displayQueue();        // Display the queue

        System.out.print("Removed numbers from the queue: "); 
        while (!theQueue.isEmpty()) {   // remove and display all items
            long n = theQueue.remove();  // (40, 50, 60, 70, 80)
            System.out.print(n + " ");
        }
        System.out.println();

    }   // end main()
  
////////////////////////////////////////////////////////////////
}
