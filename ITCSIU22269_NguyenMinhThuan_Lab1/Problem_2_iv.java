// iv. Programming Projects 2.5 in Text-Book (classDataArray.java)

import java.util.Random;

public class Problem_2_iv {

    static class Person {
        private String lastName;
        private String firstName;
        private int age;

        public Person(String lastName, String firstName, int age) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.age = age;
        }

        public void displayPerson() {
            System.out.print(" Last name: " + lastName);
            System.out.print(", First name: " + firstName);
            System.out.println(", Age: " + age);
        }

        public String getLast() {
            return lastName;
        }
    }

    static class ClassDataArray {
        private Person[] a;
        private int nElems;

        public ClassDataArray(int max) {
            a = new Person[max];
            nElems = 0;
        }

        public Person find(String searchName) {
            int j;
            for (j = 0; j < nElems; j++) {
                if (a[j].getLast().equals(searchName)) {
                    break;
                }
            }
            if (j == nElems) {
                return null;
            } else {
                return a[j];
            }
        }

        public void insert(String last, String first, int age) {
            a[nElems] = new Person(last, first, age);
            nElems++;
        }

        public boolean delete(String searchName) {
            int j;
            for (j = 0; j < nElems; j++) {
                if (a[j].getLast().equals(searchName)) {
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

        public void displayA() {
            for (int j = 0; j < nElems; j++) {
                a[j].displayPerson();
            }
        }
    }

    static class ClassDataApp {
        public static void main(String[] args) {
            int maxSize = 100;
            ClassDataArray arr;
            arr = new ClassDataArray(maxSize);

            arr.insert("Evans", "Patty", 24);
            arr.insert("Smith", "Lorraine", 37);
            arr.insert("Yee", "Tom", 43);
            arr.insert("Adams", "Henry", 63);
            arr.insert("Hashimoto", "Sato", 21);
            arr.insert("Stimson", "Henry", 29);
            arr.insert("Velasquez", "Jose", 72);
            arr.insert("Lamarque", "Henry", 54);
            arr.insert("Vang", "Minh", 22);
            arr.insert("Creswell", "Lucinda", 18);

            arr.displayA();

            String searchKey = "Stimson";
            Person found;

            found = arr.find(searchKey);
            if (found != null) {
                System.out.print("Found ");
                found.displayPerson();
            } else
                System.out.println("Can't find " + searchKey);
            System.out.println("Deleting Smith, Yee, and Creswell");
            arr.delete("Smith");
            arr.delete("Yee");
            arr.delete("Creswell");
            arr.displayA();

            // Demonstrate merging two ordered arrays
            int maxSize2 = 10;
            OrdArray ordArray1 = new OrdArray(maxSize2);
            OrdArray ordArray2 = new OrdArray(maxSize2);

            Random rand = new Random();
            for (int i = 0; i < 5; i++) {
                ordArray1.insert(rand.nextInt(100));
                ordArray2.insert(rand.nextInt(100));
            }

            System.out.println("Array 1:");
            ordArray1.display();
            System.out.println("Array 2:");
            ordArray2.display();

            OrdArray mergedArray = new OrdArray(maxSize2 * 2);
            mergedArray = mergedArray.merge(ordArray1, ordArray2);

            System.out.println("Merged Array:");
            mergedArray.display();
        }
    }

    static class OrdArray {
        private long[] a;
        private int nElems;

        public OrdArray(int max) {
            a = new long[max];
            nElems = 0;
        }

        public int size() {
            return nElems;
        }

        public int find(long searchKey) {
            int lowerBound = 0;
            int upperBound = nElems - 1;
            int curIn;

            while (true) {
                curIn = (lowerBound + upperBound) / 2;
                if (a[curIn] == searchKey)
                    return curIn;
                else if (lowerBound > upperBound)
                    return nElems;
                else {
                    if (a[curIn] < searchKey)
                        lowerBound = curIn + 1;
                    else
                        upperBound = curIn - 1;
                }
            }
        }

        public void insert(long value) {
            int j;
            for (j = 0; j < nElems; j++)
                if (a[j] > value)
                    break;
            for (int k = nElems; k > j; k--)
                a[k] = a[k - 1];
            a[j] = value;
            nElems++;
        }

        public void display() {
            for (int j = 0; j < nElems; j++)
                System.out.print(a[j] + " ");
            System.out.println("");
        }

        public OrdArray merge(OrdArray arr1, OrdArray arr2) {
            OrdArray mergedArray = new OrdArray(arr1.size() + arr2.size());

            int index1 = 0, index2 = 0;
            while (index1 < arr1.size() && index2 < arr2.size()) {
                if (arr1.a[index1] < arr2.a[index2]) {
                    mergedArray.insert(arr1.a[index1]);
                    index1++;
                } else {
                    mergedArray.insert(arr2.a[index2]);
                    index2++;
                }
            }

            while (index1 < arr1.size()) {
                mergedArray.insert(arr1.a[index1]);
                index1++;
            }

            while (index2 < arr2.size()) {
                mergedArray.insert(arr2.a[index2]);
                index2++;
            }

            return mergedArray;
        }
    }
}

