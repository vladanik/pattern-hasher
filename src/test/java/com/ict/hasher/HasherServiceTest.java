package com.ict.hasher;

import com.ict.hasher.HasherService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HasherServiceTest {

    @Test
    public void testHashingConsistency() {
        HasherService hasherService = new HasherService("securePattern");
        String input = "HelloWorld";
        String hashed = hasherService.hash(input);

        assertNotNull(hashed);
        assertEquals(255, hashed.length(), "Hashed output should be of fixed length");
    }

    @Test
    public void testHashingDifferentInputs() {
        HasherService hasherService = new HasherService("securePattern");
        String hash1 = hasherService.hash("Hello");
        String hash2 = hasherService.hash("World");

        assertNotEquals(hash1, hash2, "Different inputs should generate different hashes");
    }

    @Test
    public void testValidationWithinAsciiRange() {
        HasherService hasherService = new HasherService("pattern");
        char validatedChar = hasherService.hash("A").charAt(0);

        assertTrue(validatedChar >= 33 && validatedChar <= 126,
                "Validated character should be within ASCII printable range");
    }
}
