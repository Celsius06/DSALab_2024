public class Problem_LinkStackApp {
// linkStack.java
// demonstrates a stack implemented as a list
// to run this program: C>java LinkStackApp
////////////////////////////////////////////////////////////////
    static class Link {
        public long dData;             // data item
        public Link next;              // next link in list
        // -------------------------------------------------------------
        public Link(long dd)           // constructor
        { 
            dData = dd; 
        }
        // -------------------------------------------------------------
        public void displayLink()      // display ourself
        { 
            System.out.print(dData + " "); 
        }
    }  // end class Link
    ////////////////////////////////////////////////////////////////
    static class LinkList
    {
        private Link first;            // ref to first item on list
    // -------------------------------------------------------------
        public LinkList()              // constructor
        { 
            first = null; 
        }                              // no items on list yet
        // -------------------------------------------------------------
        public boolean isEmpty()       // true if list is empty
        { 
            return (first == null); 
        }
        // -------------------------------------------------------------
        public void insertFirst(long dd) // insert at start of list
        {                           // make new link
            Link newLink = new Link(dd);
            newLink.next = first;       // newLink --> old first
            first = newLink;            // first --> newLink
        }
        // -------------------------------------------------------------
        public long deleteFirst()      // delete first item
        {                           // (assumes list not empty)
            Link temp = first;          // save reference to link
            first = first.next;         // delete it: first-->old next
            return temp.dData;          // return deleted link
        }
        // -------------------------------------------------------------
        public void displayList()
        {
            Link current = first;       // start at beginning of list
            while(current != null)      // until end of list,
            {
                current.displayLink();   // print data
                current = current.next;  // move to next link
            }
        System.out.println("");
        }
        // -------------------------------------------------------------
    }  // end class LinkList
    ////////////////////////////////////////////////////////////////
    static class LinkStack
    {
        private LinkList theList;
        //--------------------------------------------------------------
            public LinkStack()             // constructor
        {
            theList = new LinkList();
        }
        //--------------------------------------------------------------
            public void push(long j)     // put item on top of stack
        {
            theList.insertFirst(j);
        }
        //--------------------------------------------------------------
            public long pop()            // take item from top of stack
        {
            return theList.deleteFirst();
        }
        //--------------------------------------------------------------
            public boolean isEmpty()       // true if stack is empty
        {
            return ( theList.isEmpty() );
        }
        //--------------------------------------------------------------
            public void displayStack()
        {
            System.out.print("Stack (top --> bottom): ");
            theList.displayList();
        }
        //--------------------------------------------------------------
    }  // end class LinkStack
    ////////////////////////////////////////////////////////////////

    public static void main(String[] args){
        // Application to reverse the given list using given LinkStack above
        LinkStack theStack = new LinkStack(); // make stack

        // Initial list
        theStack.push(20);                    // push items
        theStack.push(40);
        theStack.push(60);                    // push items
        theStack.push(80);

        System.out.print("Initial list: ");
        theStack.displayStack();

        LinkStack reversedStack = new LinkStack();
        while (!theStack.isEmpty()) {
            long data = theStack.pop();
            reversedStack.push(data);
        }

        System.out.print("Reversed list: ");
        reversedStack.displayStack();

    }  // end main()
////////////////////////////////////////////////////////////////
}   // end Problem_LinkStackApp
