import java.util.Scanner;

public class ConditionsDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your marks: ");
        int marks = sc.nextInt();

        // If statement
        if (marks >= 40) {
            System.out.println("You are Pass");
        }

        // Else If statement
        if (marks >= 90) {
            System.out.println("Grade: A+");
        }
        else if (marks >= 75) {
            System.out.println("Grade: A");
        }
        else if (marks >= 60) {
            System.out.println("Grade: B");
        }
        else {
            System.out.println("Grade: C");
        }

        // Nested If statement
        if (marks >= 40) {
            if (marks >= 18) {
                System.out.println("Eligible for next level");
            }
        }

        sc.close();
    }
}