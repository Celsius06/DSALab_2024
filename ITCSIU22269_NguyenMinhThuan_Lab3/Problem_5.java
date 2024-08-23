import java.util.Random;

public class Problem_5 {
    static class PriorityQ {
        private int maxSize;
        private long[] queArray;
        private int nItems;

        public PriorityQ(int s) {
            maxSize = s;
            queArray = new long[maxSize];
            nItems = 0;
        }

        public void insert(long item) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot insert " + item);
                return;
            }
            int j;
            if (nItems == 0)
                queArray[nItems++] = item;
            else {
                for (j = nItems - 1; j >= 0; j--) {
                    if (item > queArray[j])
                        queArray[j + 1] = queArray[j];
                    else
                        break;
                }
                queArray[j + 1] = item;
                nItems++;
            }
        }

        public long remove() {
            return queArray[--nItems];
        }

        public long peekMin() {
            return queArray[nItems - 1];
        }

        public boolean isEmpty() {
            return (nItems == 0);
        }

        public boolean isFull() {
            return (nItems == maxSize);
        }
    }

    static class PriorityQAppMain {
        public static void main(String[] args) {
            final int maxSize = 5; // Size of the queue
            final int maxServingTime = 10; // Maximum serving time for each customer
            final double customerArrivalRate = 0.5; // Rate at which customers arrive at the queue

            PriorityQ thePQ = new PriorityQ(maxSize);
            Random random = new Random();

            int currentTime = 0;

            // Simulation loop
            while (currentTime < 6) { // Simulation time units: 6
                // Check if a new customer arrives
                if (random.nextDouble() < customerArrivalRate) {
                    int servingTime = random.nextInt(maxServingTime) + 1;
                    thePQ.insert(servingTime);
                    System.out.println("Customer arrived with serving time " + servingTime);
                }

                // Serve the customer with the minimum serving time
                if (!thePQ.isEmpty()) {
                    long servingTime = thePQ.remove();
                    System.out.println("Serving customer with serving time " + servingTime);
                }

                currentTime++;
                System.out.println("Current time: " + currentTime);
            }
        }
    }
}
