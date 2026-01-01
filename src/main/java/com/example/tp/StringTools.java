package com.example.tp;

public class StringTools {

    /**
     * Retourne un extrait sûr entre [start, end) avec règles de bornes :
     * - start < 0 -> 0
     * - end > length -> length
     * - start >= end -> ""
     * - s == null -> IllegalArgumentException
     */
    public String safeSlice(String s, int start, int end) {
        if (s == null) throw new IllegalArgumentException("null s");
        int n = s.length();
        if (start < 0) start = 0;
        if (end > n) end = n;
        if (start >= end) return "";
        return s.substring(start, end);
    }

    /** Retourne vrai si s est palindrome en ignorant la casse et les espaces. */
    public boolean isLoosePalindrome(String s) {
        if (s == null) return false;
        String norm = s.replaceAll("\\s+","").toLowerCase();
        int i = 0, j = norm.length() - 1;
        while (i < j) {
            if (norm.charAt(i) != norm.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
