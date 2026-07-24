public class LambdaHello {
    public static void main(String[] args) {
        Runnable hello = () -> System.out.println("Hello Vicky");
        hello.run();
    }
}
