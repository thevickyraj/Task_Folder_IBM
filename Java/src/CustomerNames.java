import java.util.Scanner;

public class CustomerNames {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] customers = new String[5];

        // Accept customer names
        for (int i = 0; i < customers.length; i++) {
            System.out.print("Enter customer name " + (i + 1) + ": ");
            customers[i] = sc.nextLine();
        }

        // Display customer names using for-each loop
        System.out.println("\nCustomer Names:");

        for (String name : customers) {
            System.out.println(name);
        }

        sc.close();
    }
}