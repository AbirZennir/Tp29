package com.example.tp;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("StringTools - tests de bornes et logique")
class StringToolsTest {

    private final StringTools tools = new StringTools();

    @Test
    void safeSlice_null_throws() {
        assertThrows(IllegalArgumentException.class, () -> tools.safeSlice(null, 0, 1));
    }

    @Test
    void safeSlice_bounds() {
        assertEquals("", tools.safeSlice("abc", 2, 2));
        assertEquals("bc", tools.safeSlice("abc", 1, 5)); // end tronqué
        assertEquals("ab", tools.safeSlice("abc", -10, 2)); // start corrigé
        assertEquals("", tools.safeSlice("abc", 3, 0)); // start>=end
    }

    @Test
    void palindrome_basic() {
        assertTrue(tools.isLoosePalindrome("Kayak"));
        assertTrue(tools.isLoosePalindrome("n u r s e s r u n"));
        assertFalse(tools.isLoosePalindrome("abc"));
        assertFalse(tools.isLoosePalindrome(null));
    }
}
