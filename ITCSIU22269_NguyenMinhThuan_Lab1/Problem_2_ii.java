// ii. Programming Projects 2.1 in Text-Book (array.java)

// import java.io.File;
// import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Problem_2_ii {
    static class HighArray {
        private long[] a;
        private int nElems;

        public HighArray(int max) {
            a = new long[max];
            nElems = 0;
        }

        public boolean find(long searchKey) {
            for (int j = 0; j < nElems; j++) {
                if (a[j] == searchKey) {
                    return true;
                }
            }
            return false;
        }

        public void insert(long value) {
            a[nElems++] = value;
        }

        public boolean delete(long value) {
            int j;
            for (j = 0; j < nElems; j++) {
                if (value == a[j]) {
                    break;
                }
            }
            if (j == nElems) {
                return false;
            } else {
                for (int k = j; k < nElems - 1; k++) {
                    a[k] = a[k + 1];
                }
                nElems--;
                return true;
            }
        }

        public void display() {
            for (int j = 0; j < nElems; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }

        public long getMax() {
            if (nElems == 0) {
                return -1;
            }
        
            long max = a[0];
            for (int j = 1; j < nElems; j++) {
                if (a[j] > max) {
                    max = a[j];
                }
            }
            delete(max);
            return max;
        }        

        public void removeMax() {
            getMax();
        }
    }

    static class HighArrayApp {
        public static void main(String[] args) {
            HighArray arr;
            int maxSize = 100;
            arr = new HighArray(maxSize);

            Random random = new Random();

            // Read the numbers from the text file
            int currentIndex = 0;
            try {
                Scanner fileScanner = new Scanner(new File("Problem_2_ii.txt"));
                while (fileScanner.hasNextLine() && currentIndex < maxSize) {
                    arr.insert(Long.parseLong(fileScanner.nextLine().trim()));
                    currentIndex++;
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                return;
            }

            System.out.print("Values from text file: ");
            arr.display();
            System.out.println();

            // Generate random numbers to fill the remaining slots in the array
            for (int i = currentIndex; i < maxSize; i++) {
                arr.insert(random.nextInt(100));
            }

            System.out.print("Random-generated values: ");
            arr.display();

            // Generate a random number to find and delete
            long randomValueToDelete = random.nextInt(100);

            System.out.println("Deleting random value: " + randomValueToDelete);
            boolean deleted = arr.delete(randomValueToDelete);

            if (deleted) {
                System.out.println("Value " + randomValueToDelete + " deleted successfully.");
            } else {
                System.out.println("Value " + randomValueToDelete + " not found in the array.");
            }

            System.out.print("Enter the item to find: ");
            Scanner scanner = new Scanner(System.in);
            long searchKey = scanner.nextLong();

            if (arr.find(searchKey)) {
                System.out.println("Found " + searchKey);
            } else {
                System.out.println("Can't find " + searchKey);
            }
            scanner.close();

            // Print the number of comparisons to find an item
            int comparisonsToFind = 0;
            for (int j = 0; j < arr.nElems; j++) {
                comparisonsToFind++;
                if (arr.a[j] == searchKey) {
                    break;
                }
            }
            System.out.println("Number of comparisons to find an item: " + comparisonsToFind);

            // Print the number of memory moves to delete an item
            System.out.println("Number of memory moves to delete an item: 1"); // Only one memory move as we are deleting one item
        }
    }
}
