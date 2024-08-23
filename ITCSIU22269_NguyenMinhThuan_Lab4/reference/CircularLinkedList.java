package reference;

public class CircularLinkedList {
    private Node current = null;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (current == null) {
            newNode.next = newNode;
        } else {
            newNode.next = current.next;
            current.next = newNode;
        }
        current = newNode;
    }

    public boolean search(int data) {
        if (current == null) return false;
        Node temp = current;
        do {
            if (temp.data == data) return true;
            temp = temp.next;
        } while (temp != current);
        return false;
    }

    public void delete(int data) {
        if (current == null) return;
        if (current.data == data) {
            if (current.next == current) {
                current = null;
            } else {
                Node temp = current.next;
                while (temp.next != current) {
                    temp = temp.next;
                }
                temp.next = current.next;
                current = temp;
            }
        } else {
            Node prev = current;
            Node curr = current.next;
            while (curr != current && curr.data != data) {
                prev = curr;
                curr = curr.next;
            }
            if (curr.data == data) {
                prev.next = curr.next;
            }
        }
    }

    public void step() {
        if (current != null) {
            current = current.next;
        }
    }

    public void display() {
        if (current == null) return;
        Node temp = current;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != current);
        System.out.println();
    }

    public static void main(String[] args) {
            CircularLinkedList list = new CircularLinkedList();
    
            // Insert elements
            list.insert(1);
            list.insert(2);
            list.insert(3);
            list.insert(4);
            list.insert(5);
    
            // Display the list
            System.out.println("Circular Linked List:");
            list.display();
    
            // Search for an element
            System.out.println("Search for 3: " + list.search(3));
            System.out.println("Search for 6: " + list.search(6));
    
            // Delete an element
            list.delete(3);
            System.out.println("After deleting 3:");
            list.display();
    
            // Step to the next element
            list.step();
            System.out.println("After stepping:");
            list.display();
        }
}
    

