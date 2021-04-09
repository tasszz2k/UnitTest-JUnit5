package healthycoderapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test
 *
 * @author AnhDT118
 * @since 1.0
 */
public class TestX {
    @Test
    public void whenAssertingArraysEquality_thenEqual() {
        char[] expected = {'C', 'o', 'd', 'e', 'G', 'y', 'm'};
        char[] actual = "CodeGym".toCharArray();
        assertArrayEquals(expected, actual, "Mảng phải giống nhau");
    }

}
