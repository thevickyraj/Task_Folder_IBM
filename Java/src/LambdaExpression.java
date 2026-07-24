interface Calculator{
    int compute(int a , int b);
}
public class LambdaExpression {
    public static void main(String[] args) {
        Calculator multiply = (a, b) -> a * b;
        int result = multiply.compute(10, 20);
        System.out.println("prod is : " + result);
    }
}
