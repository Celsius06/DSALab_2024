public class Problem_4 {
    static class StackX {
        private int maxSize;        // size of stack array
        private long[] stackArray;
        private int top;            // top of stack

        public StackX(int s)         // constructor
        {
            maxSize = s;             // set array size
            stackArray = new long[maxSize];  // create array
            top = -1;                // no items yet
        }

        public void push(long j)    // put item on top of stack
        {
            if ((top + 1) == maxSize) {
                System.out.println("Stack is full. Couldn't add " + j);
                return;
            }

            stackArray[++top] = j;     // increment top, insert item
        }

        public long pop()           // take item from top of stack
        {
            if (top < 0) {
                System.out.println("Stack is empty. Can't pop any more");
                return -1;
            }

            return stackArray[top--];  // access item, decrement top
        }

        public long peek()          // peek at top of stack
        {
            return stackArray[top];
        }

        public boolean isEmpty()    // true if stack is empty
        {
            return (top == -1);
        }

        public boolean isFull()     // true if stack is full
        {
            return (top == maxSize - 1);
        }

        // Method to display the stack array
        public void displayStackArray() {
            System.out.print("Stack Array: ");
            for (int i = 0; i < maxSize; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }

        // Method to display the stack itself
        public void displayTrueStack() {
            System.out.print("Stack: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }  // end class StackX

    public static void main(String[] args) {
        StackX theStack = new StackX(10);  // make new stack
        theStack.push(20);               // push items onto stack
        theStack.push(40);
        theStack.push(60);
        theStack.push(80);

        System.out.print("Stack numbers (in reverse order): ");
        while (!theStack.isEmpty()) {
            long value = theStack.pop();
            System.out.print(value + " ");
        }
        System.out.println("\n");

        StackX sX = new StackX(5);
        sX.push(10);
        sX.push(20);
        sX.push(30);
        sX.push(40);
        sX.push(50);
        

        System.out.println("Removing numbers from StackX: ");
        while (!sX.isEmpty()) {
            sX.pop();
        }
        
        // Display labStackX after removing elements
        sX.displayStackArray();
        sX.displayTrueStack();
    }  // end main()
}  // end class Problem_4
