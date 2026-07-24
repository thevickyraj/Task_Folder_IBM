import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator cal = new Calculator();
    @Test
    void additionPass() {
        assertEquals(15, cal.add(10, 5),"Expected 15");
    }
    @Test
    void additionFail(){
        Assertions.assertNotEquals(17, cal.add(10,7),"Expected 20");
    }
}