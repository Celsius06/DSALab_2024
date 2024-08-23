package Problem_LinkQueueApp;

class LinkQueueApp {
   public static void main(String[] args) {
      LinkQueue theQueue = new LinkQueue();
      theQueue.insert(1);                 // insert items
      theQueue.insert(2);
      theQueue.insert(3);
      theQueue.insert(4);
      theQueue.insert(5);                 // insert items
      theQueue.insert(6);
      theQueue.insert(7);
      theQueue.insert(8);
      theQueue.insert(9);                 // insert items
      theQueue.insert(10);

      theQueue.displayQueue();             // display queue

      theQueue.remove();                   // remove items
      theQueue.remove();

      theQueue.displayQueue();             // display queue

      theQueue.remove();                   // remove items
      theQueue.remove();

      theQueue.displayQueue();             // display queue
   }  // end main()
}  // end class LinkQueueApp
