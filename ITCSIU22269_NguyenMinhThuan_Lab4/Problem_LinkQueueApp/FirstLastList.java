package Problem_LinkQueueApp;

public class FirstLastList
   {
   public Link first;               // ref to first item
   public Link last;                // ref to last item
   private int size;
// -------------------------------------------------------------
   public FirstLastList()            // constructor
      {
      first = null;                  // no items on list yet
      last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { return first==null; }
// -------------------------------------------------------------
   public void insertLast(long dd) // insert at end of list
      {
      Link newLink = new Link(dd);   // make new link
      if( isEmpty() )                // if empty list,
         first = newLink;            // first --> newLink
      else
         last.next = newLink;        // old last --> newLink
      last = newLink;                // newLink <-- last
      }
// -------------------------------------------------------------
   // public long deleteFirst()         // delete first link
   //    {                              // (assumes non-empty list)
   //       long temp = first.dData;
   //       if(first.next == null)         // if only one item
   //          last = null;                // null <-- last
   //       first = first.next;            // first --> old next
   //       return temp;
   //    }
// -------------------------------------------------------------
   public long deleteFirst() {
      if (isEmpty()) {
         System.out.println("Empty list. Nothing to delete.");
         return -1;
      }

      long temp = first.dData;
      if (first.next == null) {  // if only one item
         last = null;            // null <-- last
         first = first.next;     // first --> old next
      }
      return temp;
   }
// -------------------------------------------------------------
   public void displayList()
      {
      Link current = first;          // start at beginning
      while(current != null)         // until end of list,
         {
         current.displayLink();      // print data
         current = current.next;     // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   public int size() {
      return size;
   }
}  // end class FirstLastList
////////////////////////////////////////////////////////////////
