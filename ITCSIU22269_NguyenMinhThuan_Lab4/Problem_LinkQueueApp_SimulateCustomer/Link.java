package Problem_LinkQueueApp_SimulateCustomer;

import java.util.Random;

class Link
   {
   public long dData;                // data item
   public Link next;                 // next link in list
   public int stime;                 // Service Time (represents  the time needed to serve a customer)
   public int jtime;                 // Join Time (represents the rate at which customers join the queue)
// -------------------------------------------------------------
   public Link(long d, int jtime)               // constructor
      { 
         dData = d;
         Random r = new Random();
         stime = r.nextInt(10) + 1;  // the value of the variable "time" will be randomly generated from 1 to 10
         this.jtime = jtime;
      }
// -------------------------------------------------------------
   public void displayLink()         // display this link
      { 
         // Cus stands for Customer, T stands for time
         System.out.print("Cus " + dData + " (Service Time: " + stime + ", Join Time: " + jtime + "); ");
      }
// -------------------------------------------------------------
   }  // end class Link
////////////////////////////////////////////////////////////////
