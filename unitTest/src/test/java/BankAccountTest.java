import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    @Test
    void testWithdrawSuccess() {
        BankAccount account = new BankAccount("123", 1000);

        account.withdraw(200);

        assertEquals(800, account.getBalance());
    }

    // Test withdrawal with insufficient balance
    @Test
    void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount("123", 100);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200);
        });

        assertEquals("Insufficient balance", ex.getMessage());
    }
    @Test
    void testWithdrawFailMessage() {
        BankAccount account = new BankAccount("123", 100);

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(200);
        });

        assertEquals("Balance is Low", ex.getMessage()); // Fails
    }

}
