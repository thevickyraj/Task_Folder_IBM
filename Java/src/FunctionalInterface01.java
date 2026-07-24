@FunctionalInterface
interface InputOutput {
    float takeInput(int a, int b);
}

public class FunctionalInterface01 {
    public static void main(String[] args) {

        InputOutput input = (a, b) -> (float) (a + b) ;

        float result = input.takeInput(10, 20);

        System.out.println(result);
    }
}