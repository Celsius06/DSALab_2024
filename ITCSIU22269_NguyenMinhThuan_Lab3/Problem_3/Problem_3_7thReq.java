package Problem_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Problem_3_7thReq {
    static class Customer {
        private int id;
        private int servingTime;

        public Customer(int id, int servingTime) {
            this.id = id;
            this.servingTime = servingTime;
        }

        public int getServingTime() {
            return servingTime;
        }
    }

    public static void main(String[] args) {
        // Parameters to investigate
        final int queueSize = 5; // Size of the queue
        final int minServingTime = 1; // Minimum serving time for each customer
        final int maxServingTime = 5; // Maximum serving time for each customer
        final double customerArrivalRate = 0.4; // Rate at which customers arrive at the queue

        // Initialize the queue
        Queue<Customer> theQueue = new LinkedList<>();

        Random random = new Random();

        int currentTime = 0;
        int customerId = 1;

        // Simulation 
        while (currentTime < 20) { 

            // Check if a new customer arrives
            if (random.nextDouble() < customerArrivalRate) {
                int servingTime = random.nextInt(maxServingTime - minServingTime + 1) + minServingTime;
                Customer newCustomer = new Customer(customerId++, servingTime);
                if (theQueue.size() < queueSize) { // Check if the queue is not full
                    theQueue.offer(newCustomer);
                    System.out.println("Customer " + newCustomer.id + " arrived with serving time " + newCustomer.servingTime);
                } else {
                    System.out.println("Customer " + newCustomer.id + " arrived but the queue is full. They left.");
                }
            }

            // Serve the customer at the front of the queue
            if (!theQueue.isEmpty()) {
                Customer servingCustomer = theQueue.poll();
                System.out.println("Serving customer " + servingCustomer.id + " with serving time " + servingCustomer.getServingTime());
            }

            currentTime++;

            System.out.println("Current time: " + currentTime);
            System.out.println("Queue size: " + theQueue.size());
            System.out.println();
        }
    }
}
