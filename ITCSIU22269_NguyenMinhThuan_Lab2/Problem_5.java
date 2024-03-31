import java.util.Arrays;

public class Problem_5 {
    static class Student {
        private String fName;
        private String lName;
        private int grade;

        public Student(String fName, String lName, int grade) {
            this.fName = fName;
            this.lName = lName;
            this.grade = grade;
        }

        public String getfName() {
            return fName;
        }

        public String getlName() {
            return lName;
        }

        public int getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return  "First Name: '" + fName + '\'' +
                    ", Last Name = '" + lName + '\'' +
                    ", Grade = " + grade;
        }
    }

    static class ArrayInOb {
        private Student[] a;
        private int nElems;

        public ArrayInOb(int max) {
            a = new Student[max];
            nElems = 0;
        }

        public void insert(String firstName, String lastName, int grade) {
            a[nElems] = new Student(firstName, lastName, grade);
            nElems++;
        }

        public void display() {
            for (int j = 0; j < nElems; j++)
                System.out.println(a[j]);
        }

        // Request 2: Add methods to sort the array by first name, last name, and by grade.
        public void insSortFName() {
            Arrays.sort(a, 0, nElems, (s1, s2) -> s1.getfName().compareTo(s2.getfName()));
        }

        public void insSortLName() {
            Arrays.sort(a, 0, nElems, (s1, s2) -> s1.getlName().compareTo(s2.getlName()));
        }

        public void insSortGrade() {
            Arrays.sort(a, 0, nElems, (s1, s2) -> Integer.compare(s1.getGrade(), s2.getGrade()));
        }
    }


    public static void main(String[] args) {
            int maxSize = 100;
            ArrayInOb arr = new ArrayInOb(maxSize);

            // Request 1: Add a main() method and add create an array of 10 students.
            arr.insert("A", "J", 10);
            arr.insert("B", "I", 20);
            arr.insert("C", "H", 30);
            arr.insert("D", "G", 40);
            arr.insert("E", "F", 50);
            arr.insert("F", "E", 60);
            arr.insert("G", "D", 70);
            arr.insert("H", "C", 80);
            arr.insert("I", "B", 90);
            arr.insert("J", "A", 100);

            System.out.println("Initial Array:");
            arr.display();

            arr.insSortFName();
            System.out.println("\nThe sorted array by first name:");
            arr.display();

            arr.insSortLName();
            System.out.println("\nThe sorted array by last name:");
            arr.display();

            arr.insSortGrade();
            System.out.println("\nThe sorted array by grade:");
            arr.display();
    }
}
