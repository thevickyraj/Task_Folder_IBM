import java.util.ArrayDeque;
import java.util.Deque;

public class DemoStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        //Adding the elements
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);

        //Remove the element
        stack.pop();
        System.out.println(stack);

        //Displaying the top element
        System.out.println(stack.peek());
    }
}
