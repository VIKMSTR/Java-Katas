package cz.vikmstr.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatJumpsTest {

    @Test
    void solution() {
        assertEquals(2, CatJumps.solution(1, 5));
        assertEquals(2, CatJumps.solution(1, 7));
        assertEquals(3, CatJumps.solution(1, 10));
    }
}