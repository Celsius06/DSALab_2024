package Problem_3;

public class Problem_3_6thReq {

  static class Queue {
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int s) { // constructor
      maxSize = s;
      queArray = new long[maxSize];
      front = 0;
      rear = -1;
      nItems = 0;
    }

    public void insert(long j) { 
      if (rear == maxSize - 1) { 
        rear = -1;
      }
      queArray[++rear] = j;
      nItems++;
    }

    public long remove() throws InterruptedException { 
      long temp = queArray[front++]; 
      if (front == maxSize) { 
        front = 0;
      }
      nItems--;

    
      Thread.sleep(1000); 

      return temp;
    }

    public long peekFront() { // peek at front of queue
      return queArray[front];
    }

    public boolean isEmpty() { // true if queue is empty
      return (nItems == 0);
    }

    public boolean isFull() { // true if queue is full
      return (nItems == maxSize);
    }

    public int size() { // number of items in queue
      return nItems;
    }

    public long removeNth(int n) {
      if (isEmpty()) {
          System.out.println("Queue is empty. Can't remove any more.");
          return -1;
      }
      
      if (n <= 0 || n > nItems) {
          System.out.println("Invalid value for N.");
          return -1;
      }
      
      long removedItem = -1;
      if (n == 1) {
          removedItem = queArray[front++];
          if (front == maxSize) {
              front = 0;
          }
      } else {
          int removedIndex = (front + n - 1) % maxSize;
          removedItem = queArray[removedIndex];
          for (int i = removedIndex; i != rear; i = (i + 1) % maxSize) {
              queArray[i] = queArray[(i + 1) % maxSize];
          }
          rear = (rear - 1 + maxSize) % maxSize;
      }
      nItems--;
      return removedItem;
    }
  } // end class Queue
  ////////////////////////////////////////////////////////////////

public static void main(String[] args) throws InterruptedException {
      Queue theQueue = new Queue(5); 

      theQueue.insert(10); // insert items
      theQueue.insert(20);
      theQueue.insert(30);
      theQueue.insert(40);
      theQueue.insert(50);

      System.out.print("Removing 3rd item: ");
      long removed = theQueue.removeNth(3); 
      System.out.println(removed); 

      System.out.print("\nRemoving 2nd item: ");
      removed = theQueue.removeNth(2); 
      System.out.println(removed); 

      System.out.print("\nRemaining numbers: "); 
      while (!theQueue.isEmpty()) {
        System.out.print(theQueue.remove() + " "); 
      }
      System.out.println("");
    } // end main()
  } // end class QueueApp
////////////////////////////////////////////////////////////////
