package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Order;

public class OrderedTests {

    @Test
    @Order(1)
    public void test1() {
        System.out.println("First test");
    }

    @Test
    @Order(2)
    public void test2() {
        System.out.println("Second Test");
    }
}
