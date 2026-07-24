
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class Demo06_TimeoutTest_PerformanceCheck {

    // Pass Test
    @Test
    void testQuickExecutionPass() {

        Demo06_PerformanceService service = new Demo06_PerformanceService();

        assertTimeout(Duration.ofMillis(500), () -> {
            service.quickOperation();
        });
    }

    // Fail Test
    @Test
    void testSlowExecutionFail() {

        Demo06_PerformanceService service = new Demo06_PerformanceService();

        assertTimeout(Duration.ofMillis(500), () -> {
            service.slowOperation();
        });
    }

    // Fail Test
    @Test
    void testUnrealisticTimeoutFail() {

        Demo06_PerformanceService service = new Demo06_PerformanceService();

        assertTimeout(Duration.ofMillis(50), () -> {
            service.quickOperation();
        });
    }
}