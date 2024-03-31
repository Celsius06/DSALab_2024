import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import blackboard.Student_modified;

public class Problem_1_v {
    public static void main(String[] args) throws IOException {
        String first_name, last_name;
        int grade;
        int total = 0, count = 0;
        int excellentTotal = 0, okTotal = 0, failureTotal = 0;
        int excellentCount = 0, okCount = 0, failureCount = 0;
        double average, excellentAverage, okAverage, failureAverage;

        Scanner fileInput = new Scanner(new File("blackboard/students.txt"));

        while (fileInput.hasNext()) {
            first_name = fileInput.next();
            last_name = fileInput.next();
            grade = fileInput.nextInt();

            Student_modified st = new Student_modified(first_name, last_name, grade);

            // Use getter method to access last name
            System.out.println(st.getLname());

            // Calculate totals and counts
            total += grade;
            count++;

            // Classify student and update counts and totals
            if (grade > 89) {
                excellentTotal += grade;
                excellentCount++;
            } else if (grade >= 60 && grade <= 89) {
                okTotal += grade;
                okCount++;
            } else {
                failureTotal += grade;
                failureCount++;
            }
        }

        // Calculate averages
        average = (double) total / count;
        excellentAverage = (excellentCount != 0) ? (double) excellentTotal / excellentCount : 0;
        okAverage = (okCount != 0) ? (double) okTotal / okCount : 0;
        failureAverage = (failureCount != 0) ? (double) failureTotal / failureCount : 0;

        // Format averages to three significant figures
        String formattedAverage = String.format("%.3f", average);
        String formattedExcellentAverage = String.format("%.3f", excellentAverage);
        String formattedOkAverage = String.format("%.3f", okAverage);
        String formattedFailureAverage = String.format("%.3f", failureAverage);

        // Result
        System.out.println("There are " + count + " students with the total average grade of " + formattedAverage);
        System.out.println("Excellent Average Point: " + formattedExcellentAverage);
        System.out.println("Ok Average Point: " + formattedOkAverage);
        System.out.println("Failure Average Point: " + formattedFailureAverage);

        // Close the file scanner
        fileInput.close();
    }
}
