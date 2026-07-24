import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {

        Supplier<String> s = () -> "Hello Java";

        System.out.println(s.get());
    }
}