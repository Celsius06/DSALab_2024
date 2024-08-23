package Problem_LinkQueueApp_SimulateCustomer;

class LinkQueueApp {
   public static void main(String[] args) {
      LinkQueue theQueue = new LinkQueue();
      int ctime = 0;    // Current Time (Represents the time when the iterations are executed)
      for(int i = 1; i <= 5; i++) {
         theQueue.insert(i, ctime);                 // insert items
         ctime++; // Increment the current time after each insert
      }

      theQueue.displayQueue();             // display queue

      int time = 0;
      while(!theQueue.isEmpty()) {
         System.out.println("Iterated Time: " + time);
         theQueue.remove();                // remove items
         theQueue.displayQueue();          // display queue
         time++;
      }
   }  // end main()
}  // end class LinkQueueApp
