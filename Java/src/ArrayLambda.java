import java.util.ArrayList;

public class ArrayLambda {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.forEach(
                num  -> {
                    if(num % 2 == 0 ) System.out.println("even");
                    else System.out.println("Odd");
                }
        );
    }
}
