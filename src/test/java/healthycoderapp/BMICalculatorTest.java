package healthycoderapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * BMICalculatorTest
 *
 * @author AnhDT118
 * @since 1.0
 */
class BMICalculatorTest {

    private String environment = "prod";

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all unit tests.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all unit tests.");
    }

    //    @Test
    @ParameterizedTest(name = "weight={0}, height={1}")
//    @ValueSource(doubles = {90.0, 89.0, 110.})
//    @CsvSource(value = {"90.0, 1.72", "89.0, 1.75", "110., 1.78"})
    @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip = 1)
    void should_ReturnTrue_When_DietRecommend(Double coderWeight, Double coderHeight) {
        // given
        double weight = coderWeight;
        double height = coderHeight;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then
        assertTrue(recommended);
    }

    @Test
    void should_ReturnFalse_When_DietRecommend() {
        // given
        double weight = 50.0;
        double height = 1.72;

        // when
        boolean recommended = BMICalculator.isDietRecommended(weight, height);

        // then
        assertFalse(recommended);
    }

    @Test
    void should_ThrowArithmeticException_When_DietRecommend() {
        // given
        double weight = 50.0;
        double height = 0;

        // when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

        // then
        assertThrows(ArithmeticException.class, executable);
    }


    @Test
    void should_ReturnCoderWithWorstBMIIn1Ms_When_CoderListHas1000Elements() {
        // Given
        Assumptions.assumeTrue(this.environment.equals("prod"));

        List<Coder> coders = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            coders.add(new Coder(1.0 + i, 10.0 + i));
        }

        Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);

        // When

        // Then
        assertTimeout(Duration.ofMillis(500), executable);
    }


}