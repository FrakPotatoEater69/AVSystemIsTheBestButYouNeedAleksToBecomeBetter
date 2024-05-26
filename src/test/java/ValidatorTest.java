import com.shakhner.util.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidatorTest {

    @Test
    void validateDirectionValueShouldReturn1Test() {
        assertEquals(1, Validator.validateDirectionValue(24));
    }

    @Test
    void validateDirectionValueShouldReturnMinus1Test() {
        assertEquals(-1, Validator.validateDirectionValue(-24));
    }
    @Test
    void validateFloorNumbersShouldReturn16(){
        Validator.setMaximumFloorsNumber(16);
        assertEquals(16, Validator.validateFloorNumber(104));
    }
}
