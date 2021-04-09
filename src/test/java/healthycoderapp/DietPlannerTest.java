package healthycoderapp;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * DietPlannerTest
 *
 * @author AnhDT118
 * @since 1.0
 */
class DietPlannerTest {

    private DietPlanner dietPlanner;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all unit tests.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all unit tests.");
    }

    @BeforeEach
    void setUp() {
        dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void tearDown() {
        System.out.println("A unit test was finished");
    }

    //    @Disabled
    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName(">>> sample method display name")
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        // Given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2202, 110, 73, 275);

        // When
        DietPlan actual = dietPlanner.calculateDiet(coder);

        // Then
        assertAll(
                () -> assertEquals(expected.getCalories(), actual.getCalories()),
                () -> assertEquals(expected.getProtein(), actual.getProtein()),
                () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate())
        );
    }

    @Nested
    @DisplayName("{{{}}} Sample inner class display name")
    class NestedClass {
        // group unit tests here
    }


    @Test
    void should_ReturnCoderWithWorstBMIIn1Ms_When_CoderListHas1000Elements() {
        // Given
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