package se.harpo.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WrapTest {
    @Test
    public void wrapPositive() {
        assertEquals(7, Wrap.wrapInsideRange(3, 9, -5));
        assertEquals(8, Wrap.wrapInsideRange(3, 9, 2));
        assertEquals(3, Wrap.wrapInsideRange(3, 9, 3));
        assertEquals(5, Wrap.wrapInsideRange(3, 9, 5));
        assertEquals(3, Wrap.wrapInsideRange(3, 9, 9));
        assertEquals(6, Wrap.wrapInsideRange(3, 9, 12));
    }

    @Test
    public void wrapNegative() {
        assertEquals(-6, Wrap.wrapInsideRange(-9, -3, -12));
        assertEquals(-9, Wrap.wrapInsideRange(-9, -3, -9));
        assertEquals(-5, Wrap.wrapInsideRange(-9, -3, -5));
        assertEquals(-9, Wrap.wrapInsideRange(-9, -3, -3));
        assertEquals(-6, Wrap.wrapInsideRange(-9, -3, 0));
    }

    @Test
    public void wrapOverZero() {
        assertEquals(0, Wrap.wrapInsideRange(-3, 3, -12));
        assertEquals(-3, Wrap.wrapInsideRange(-3, 3, -3));
        assertEquals(1, Wrap.wrapInsideRange(-3, 3, 1));
        assertEquals(-3, Wrap.wrapInsideRange(-3, 3, 3));
        assertEquals(-1, Wrap.wrapInsideRange(-3, 3, 5));
    }

    @Test
    public void continuousWrap() {
        assertEquals(0, Wrap.wrapInsideRange(0, 3, -6));
        assertEquals(1, Wrap.wrapInsideRange(0, 3, -5));
        assertEquals(2, Wrap.wrapInsideRange(0, 3, -4));
        assertEquals(0, Wrap.wrapInsideRange(0, 3, -3));
        assertEquals(1, Wrap.wrapInsideRange(0, 3, -2));
        assertEquals(2, Wrap.wrapInsideRange(0, 3, -1));
        assertEquals(0, Wrap.wrapInsideRange(0, 3, 0));
        assertEquals(1, Wrap.wrapInsideRange(0, 3, 1));
        assertEquals(2, Wrap.wrapInsideRange(0, 3, 2));
        assertEquals(0, Wrap.wrapInsideRange(0, 3, 3));
        assertEquals(1, Wrap.wrapInsideRange(0, 3, 4));
        assertEquals(2, Wrap.wrapInsideRange(0, 3, 5));
        assertEquals(0, Wrap.wrapInsideRange(0, 3, 6));
        assertEquals(1, Wrap.wrapInsideRange(0, 3, 7));
        assertEquals(2, Wrap.wrapInsideRange(0, 3, 8));
    }
}