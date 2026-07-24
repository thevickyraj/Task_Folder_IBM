import java.util.*;

public class LambdaDemo {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Before: Heloo");
            }
        };

        Runnable r2 = () -> System.out.println("After : hello");

        List<String> names = Arrays.asList("Vicky", "Raj");
        names.forEach(name -> System.out.println("Name: " +name));
        r1.run();
        r2.run();
    }

}
