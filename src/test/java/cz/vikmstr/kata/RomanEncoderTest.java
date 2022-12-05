package cz.vikmstr.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanEncoderTest {
    private RomanEncoder conversion = new RomanEncoder();

    @Test
    void solution() {
        assertEquals("I", conversion.solution(1) );
        assertEquals( "IV", conversion.solution(4));
        assertEquals( "VI", conversion.solution(6));
    }
}