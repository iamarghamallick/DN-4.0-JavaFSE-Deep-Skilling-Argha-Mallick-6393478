package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {
    private final EvenChecker check = new EvenChecker();

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,8,10})
    public void isEvenTest(int n) {
        Assertions.assertTrue(check.isEven(n));
    }
}
