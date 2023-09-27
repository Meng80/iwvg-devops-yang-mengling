package es.upm.miw.iwvg_devops.rest;

import es.upm.miw.iwvg_devops.Fraction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class FractionTest {
    private Fraction fraction;
    private Fraction fraction1;
    private Fraction fraction2;

    @BeforeEach
    public void setUp() {

        fraction = new Fraction(3, 4);
        fraction1 = new Fraction(1, 2);
        fraction2 = new Fraction(3, 4); // Example fraction for testing
    }

    @Test
    public void testDefaultConstructor() {
        Fraction defaultFraction = new Fraction();
        assertEquals(1, defaultFraction.getNumerator());
        assertEquals(1, defaultFraction.getDenominator());
    }

    @Test
    public void testGetNumerator() {
        assertEquals(3, fraction.getNumerator());
    }

    @Test
    public void testSetNumerator() {
        fraction.setNumerator(5);
        assertEquals(5, fraction.getNumerator());
    }

    @Test
    public void testGetDenominator() {
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    public void testSetDenominator() {
        fraction.setDenominator(6);
        assertEquals(6, fraction.getDenominator());
    }

    @Test
    public void testDecimal() {
        assertEquals(0.75, fraction.decimal(), 0.001); // Use delta for double comparisons
    }

    @Test
    public void testToString() {
        assertEquals("Fraction{numerator=3, denominator=4}", fraction.toString());
    }

    @Test
    public void testIsProper() {
        assertTrue(fraction1.isProper());
        assertTrue(fraction2.isProper());
    }

    @Test
    public void testIsNotProper() {
        Fraction improperFraction = new Fraction(5,4);
        assertFalse(improperFraction.isProper());
    }

    @Test
    public void testIsImproper() {
        Fraction improperFraction = new Fraction(5,4);
        assertTrue(improperFraction.isImproper());
    }

    @Test
    public void testIsNotImproper() {
        assertFalse(fraction1.isImproper());
        assertFalse(fraction2.isImproper());
    }

    @Test
    public void testIsEquivalent() {
        Fraction equivalentFraction = new Fraction(2,4);
        assertTrue(fraction1.isEquivalent(equivalentFraction));
    }

    @Test
    public void testIsNotEquivalent() {
        assertFalse(fraction1.isEquivalent(fraction2));
    }

    @Test
    public void testAdd(){
        Fraction result = fraction1.add(fraction2);
        assertEquals(10,result.getNumerator());
        assertEquals(8,result.getDenominator());
    }

    @Test
    public void testMultiply() {
        Fraction result = fraction1.multiply(fraction2);
        assertEquals(3, result.getNumerator());
        assertEquals(8, result.getDenominator());
    }

    @Test
    public void testDivide() {
        Fraction result = fraction1.divide(fraction2);
        assertEquals(4, result.getNumerator());
        assertEquals(6, result.getDenominator());
    }


}
