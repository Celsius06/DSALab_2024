package Problem_3;

public class Problem_3_1stReq {
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

        // Method to display the queue array and the front and rear indices
        public void display() {
            System.out.print("Queue array: ");
            for (int i = 0; i < maxSize; i++) {
                System.out.print(queArray[i] + " ");
            }
            System.out.println("\nFront indice: " + front + "; " + "Rear indice: " + rear);
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
    
        System.out.println("Initial queue array: ");
        theQueue.display();             // display queue state
        System.out.println();

        theQueue.remove();              // remove 3 items
        theQueue.remove();              //    (10, 20, 30)
        theQueue.remove();
    
        System.out.println("Queue array after the removal: ");
        // Now the front index is 3 because three elements have been removed from the front
        theQueue.display();             // display queue state after removals
        System.out.println();    
    
        theQueue.insert(50);            // insert 4 more items
        theQueue.insert(60);            //    (wraps around)
        theQueue.insert(70);
        theQueue.insert(80);
    
        System.out.println("Queue array after the insertion: ");    
        theQueue.display();             // display final queue state
        System.out.println();
    
        System.out.println("Final queue array after the process: ");    
        while (!theQueue.isEmpty())    // remove and display
        {                            //    all items
            long n = theQueue.remove();  // (40, 50, 60, 70, 80)
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");    
        
}       // end main()
////////////////////////////////////////////////////////////////
}
