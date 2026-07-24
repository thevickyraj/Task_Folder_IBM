public class ExceptionDemo {
    public static void main(String[] args) {

        try {
            int c = 10 / 0;
            System.out.println(c);
        }
        catch (Exception e) {
            System.out.println("Cannot divide by 0");
        }
        finally {
            System.out.println("End of the program");
        }

        System.out.println("Program continues...");
    }
}