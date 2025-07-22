package org.example;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionThrowerTest {

    @Test
    public void testThrowException() {
        ExceptionThrower thrower = new ExceptionThrower();
        Assert.assertThrows(IllegalArgumentException.class,thrower::throwException);
    }
}
