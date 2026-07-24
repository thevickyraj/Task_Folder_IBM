public class BreakContinueDemo {
    public static void main(String[] args) {

        System.out.println("Using break:");

        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;   // stops the loop completely
            }
            System.out.println(i);
        }

        System.out.println("\nUsing continue:");

        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue;   // skips only the current iteration
            }
            System.out.println(i);
        }
    }
}