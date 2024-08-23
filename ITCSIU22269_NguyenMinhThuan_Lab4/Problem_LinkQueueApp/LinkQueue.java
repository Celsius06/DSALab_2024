package Problem_LinkQueueApp;

class LinkQueue
   {
   private FirstLastList theList;
   private int removeCounter; // Add a counter to keep track of remove() calls

//--------------------------------------------------------------
   public LinkQueue()                // constructor
      { 
      theList = new FirstLastList();  // make a 2-ended list
      removeCounter = 0; // Initialize the counter to 0
      }
//--------------------------------------------------------------
   public boolean isEmpty()          // true if queue is empty
      { return theList.isEmpty(); }
//--------------------------------------------------------------
   public void insert(long j)        // insert, rear of queue
      { theList.insertLast(j); }
//--------------------------------------------------------------
// New remove() method that removes item N after N calls to the method
   public long remove()              // remove, front of queue
      {  
        removeCounter++; 
        Link current = theList.first;
        Link previous = theList.first;
        
        // If the counter is greater than the size of the list, reset it to 1
        if(removeCounter > theList.size()) {
            removeCounter = 1;
        }
        
        // Loop to the Nth item
        for(int i = 1; i < removeCounter; i++) {
            previous = current;
            current = current.next;
        }
        
        // If the item to be removed is the first item in the list
        if(current == theList.first) {
            theList.first = theList.first.next;
        } else {
            previous.next = current.next;
        }

        System.out.println("Removing " + current.dData);
        
        // If the item to be removed is the last item in the list
        if(current == theList.last) {
            theList.last = previous;
        }
        
        return current.dData;
      }
//--------------------------------------------------------------
   public void displayQueue()
      {
        System.out.print("Queue (front --> rear): ");
        theList.displayList();
      }
//--------------------------------------------------------------
}  // end class LinkQueue
