public class ReverseString {
    public static void main(String[] args) {
        String str = "Vicky";
        StringBuilder reverseStr = new StringBuilder(str).reverse();
        System.out.println("Original str "+ str);
        System.out.println("Reversed str " + reverseStr);
    }
}
