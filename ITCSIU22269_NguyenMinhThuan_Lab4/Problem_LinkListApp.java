public class Problem_LinkListApp {
// linkList.java
// demonstrates linked list
// to run this program: C>java LinkListApp
////////////////////////////////////////////////////////////////

static class Link {
   public int iData;              // data item
   public double dData;           // data item
   public Link next;              // next link in list
   // -------------------------------------------------------------
   public Link(int id, double dd) // constructor
      {
         iData = id;                 // initialize data
         dData = dd;                 // ('next' is automatically
      }                           //  set to null)
   // -------------------------------------------------------------
   public void displayLink()      // display ourself
      {
         System.out.print("{" + iData + ", " + dData + "} ");
      }
   // -------------------------------------------------------------
   // toString() methods for easy printing elements and lists
   @Override 
   public String toString () {
      return "{" + iData + ", " + dData + "}";
   }
}  // end class Link
////////////////////////////////////////////////////////////////
static class LinkList {
   private Link first;            // ref to first link on list

   // -------------------------------------------------------------
   public LinkList()              // constructor
      {
         first = null;               // no links on list yet
      }
   // -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      {
         return (first == null);
      }
   // -------------------------------------------------------------
                                 // insert at start of list
   public void insertFirst(int id, double dd)
      {                           // make new link
         Link newLink = new Link(id, dd);
         newLink.next = first;       // newLink --> old first
         first = newLink;            // first --> newLink
      }
   // -------------------------------------------------------------
   public Link deleteFirst()      // delete first item
      {                           // (assumes list not empty)
         Link temp = first;          // save reference to link
         first = first.next;         // delete it: first-->old next
         return temp;                // return deleted link
      }
   // -------------------------------------------------------------
   // Methods to access the first and the last element of the list
   public Link getFirst() {
      return first;
   }
   // -------------------------------------------------------------
   public Link getLast() {
      Link current = first;
      if (current == null) {
         return null;
      }
      while (current.next != null) {
         current = current.next;
      }
      return current;      
   }
   // -------------------------------------------------------------
   public void displayList()
      {
         System.out.print("List (first --> last): ");
         Link current = first;       // start at beginning of list
         while(current != null)      // until end of list,
            {
            current.displayLink();   // print data
            current = current.next;  // move to next link
            }
         System.out.println("");
      }
   // -------------------------------------------------------------
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("List (first --> last): ");
      Link current = first;
      while (current != null) {
         sb.append(current.toString()).append(" ");
         current = current.next;
      }
      return sb.toString();
   }
}  // end class LinkList
////////////////////////////////////////////////////////////////

   public static void main(String[] args)
      {
      LinkList theList = new LinkList();  // make new list

      theList.insertFirst(22, 2.99);      // insert four items
      theList.insertFirst(44, 4.99);
      theList.insertFirst(66, 6.99);
      theList.insertFirst(88, 8.99);

      theList.displayList();     
      System.out.println("1st element: " + theList.getFirst());
      System.out.println("2nd element: " + theList.getLast());
      }  // end main()
} // end Problem_LinkListApp
////////////////////////////////////////////////////////////////
