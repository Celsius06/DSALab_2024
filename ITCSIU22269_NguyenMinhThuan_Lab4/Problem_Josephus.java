import java.util.Scanner;

public class Problem_Josephus {
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

    public void eliminate(int step) {
        while (current != current.next) {
            for (int i = 0; i < step - 1; i++) {
                current = current.next;
            }
            System.out.print(current.next.data + " ");
            current.next = current.next.next;
        }
        System.out.println("");
        System.out.println("Last person standing: " + current.data);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the number of people in the circle: ");
        int n = s.nextInt();

        System.out.print("Enter the number used for counting off: ");
        // For example: user enters 3 => Every 3rd person is eliminated
        int m = s.nextInt();

        System.out.print("Enter the number of the person where counting starts: ");
        int start = s.nextInt();

        System.out.println("Elimination order: ");
        Problem_Josephus list = new Problem_Josephus();
        for (int i = 1; i <= n; i++) {
            list.insert(i);
        }

        for (int i = 1; i < start; i++) {
            list.current = list.current.next;
        }

        list.eliminate(m);

        s.close();
    }
}
