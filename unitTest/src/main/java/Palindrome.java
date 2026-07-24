public class Palindrome {
    public static boolean isPalindrome(String str){
        String reverse = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reverse);
    }
}
