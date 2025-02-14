package com.ict.hasher;

import com.ict.hasher.Hasher;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HasherTest {

    @Test
    public void testHashMethod() {
        String pattern = "securePattern";
        String input = "HelloWorld";

        String hash = Hasher.hash(input, pattern);
        assertNotNull(hash, "Hash should not be null");
        assertEquals(255, hash.length(), "Hashed output should be of fixed length");
    }

    @Test
    public void testEqualsMethodValidComparison() {
        String pattern = "securePattern";
        String input = "HelloWorld";

        String hash = Hasher.hash(input, pattern);
        boolean result = Hasher.equals(hash, input, pattern);

        assertTrue(result, "Hash should match the input when re-hashed with the same pattern");
    }

    @Test
    public void testEqualsMethodInvalidComparison() {
        String pattern = "securePattern";
        String input1 = "HelloWorld";
        String input2 = "DifferentText";

        String hash = Hasher.hash(input1, pattern);
        boolean result = Hasher.equals(hash, input2, pattern);

        assertFalse(result, "Hash should not match for different inputs");
    }
}
