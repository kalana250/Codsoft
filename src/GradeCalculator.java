import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Assuming three subjects

        int[] marks = new int[numSubjects];

        // Taking marks input for each subject
        for (int a = 0; a < numSubjects; a++) {
            System.out.print("Enter marks obtained in subject " + (a + 1) + ": ");
            marks[a] = scanner.nextInt();

            // Validating marks (0 to 100)
            while (marks[a] < 0 || marks[a] > 100) {
                System.out.println("Marks should be between 0 and 100.");
                System.out.print("Enter marks obtained in subject " + (a + 1) + " again: ");
                marks[a] = scanner.nextInt();
            }
        }

        // Calculate total marks
        int totMarks = 0;

        for (int mark : marks) {
            totMarks += mark;
        }

        // Calculate average percentage
        double averagePercentage = (double) totMarks / numSubjects;

        // Grade calculation
        char grade;
        if (averagePercentage >= 75) {
            grade = 'A';

        } else if (averagePercentage >= 65) {
            grade = 'B';

        } else if (averagePercentage >= 55) {
            grade = 'C';

        } else if (averagePercentage >= 35) {
            grade = 'S';

        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\nResults:");

        System.out.println("Total Marks: " + totMarks);

        System.out.println("Average Percentage: " + averagePercentage + "%");

        System.out.println("Grade: " + grade);

        System.out.println("Have a Good day!");

        scanner.close();
    }



}
