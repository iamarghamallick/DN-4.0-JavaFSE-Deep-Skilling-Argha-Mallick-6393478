package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class PerformanceTesterTest {

    @Test
    public void testPerformance() {
        PerformanceTester performanceTester = new PerformanceTester();
        Assertions.assertTimeout(Duration.ofSeconds(1), performanceTester::performTask);
    }
}
