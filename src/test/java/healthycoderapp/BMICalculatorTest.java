package healthycoderapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BMICalculatorTest
 *
 * @author AnhDT118
 * @since 1.0
 */
class BMICalculatorTest {

    @Test
    void test(){
        assertTrue(BMICalculator.isDietRecommended(89.0, 1.72));
    }

}