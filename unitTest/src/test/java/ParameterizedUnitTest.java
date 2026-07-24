import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedUnitTest {
    @ParameterizedTest
    @ValueSource(strings = {"amma", "mom", "nitin", "madam", "racecar"})
    void isPalindromeTrue(String candidate){
        Assertions.assertTrue(Palindrome.isPalindrome(candidate));
    }
    // Fail Test Case
    @Test
    void testPalindromeFail() {
        // This test will fail because "hello" is not a palindrome
        Assertions.assertTrue(Palindrome.isPalindrome("hello"),
                "Expected true but got false");
    }

    // Not Palindrome Test Cases
    @ParameterizedTest
    @ValueSource(strings = {"java", "spring", "bank", "hello", "world"})
    void testNotPalindrome(String candidate) {
        Assertions.assertFalse(Palindrome.isPalindrome(candidate));
    }
}
