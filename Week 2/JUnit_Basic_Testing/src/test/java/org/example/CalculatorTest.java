package org.example;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Setting up...");
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up...");
    }

    @Test
    public void testAdd() {
        calc = new Calculator();
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    public void testSubtract() {
        calc = new Calculator();
        assertEquals(1, calc.subtract(3, 2));
    }

    @Test
    public void testAssertions() {
        Assert.assertTrue(10 > 5);
        Assert.assertFalse(5 > 10);
        Assert.assertNull(null);
        Assert.assertNotNull(new Object());
    }
}
