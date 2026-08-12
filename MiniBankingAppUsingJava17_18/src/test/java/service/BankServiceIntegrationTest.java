package service;
import com.bank.service.BankService;
import com.model.Customer;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankServiceIntegrationTest {
    @Test
    void shouldDisplayCustomerDetails() {

        // Module 1: Customer
        Customer customer =
                new Customer(101, "Vicky", "BANK10001");

        // Module 2: BankService
        BankService bankService = new BankService();

        // Capture console output
        ByteArrayOutputStream output =
                new ByteArrayOutputStream();

        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(output));

        try {
            bankService.displayCustomer(customer);
        } finally {
            System.setOut(originalOut);
        }

        String result = output.toString();

        // Verify integration
        assertTrue(result.contains("Customer ID: 101"));
        assertTrue(result.contains("Customer Name: Vicky"));
        assertTrue(result.contains("Account Number: BANK10001"));
    }
}
