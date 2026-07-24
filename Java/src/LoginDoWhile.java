import java.util.Scanner;

public class LoginDoWhile {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String loginId;
        String password;

        do {
            System.out.print("Enter Login ID: ");
            loginId = sc.nextLine();

            System.out.print("Enter Password: ");
            password = sc.nextLine();

            if (loginId.equals("Prasunamba") && password.equals("4321")) {
                System.out.println("Welcome Prasunamba!");
                break;
            }
            else {
                System.out.println("Invalid Login ID or Password. Try again.");
            }

        } while (true);

        sc.close();
    }
}