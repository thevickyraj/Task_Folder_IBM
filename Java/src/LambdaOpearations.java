@FunctionalInterface
interface Calculate {
    int arithmeticOpearations(int a, int b);
}
public class LambdaOpearations {
    public static void main(String[] args) {

        Calculate add = (a, b) -> a + b;
        Calculate mult = (a,b) -> a*b;

        System.out.println("Sum = " + add.arithmeticOpearations(10, 20));
        System.out.println("Mult =" + mult.arithmeticOpearations(20,40));
    }
}