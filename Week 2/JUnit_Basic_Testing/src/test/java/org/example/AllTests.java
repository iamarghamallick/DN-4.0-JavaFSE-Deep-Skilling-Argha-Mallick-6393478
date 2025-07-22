package org.example;

import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasses;

@Suite
@SelectClasses({
        CalculatorTest.class,
        EvenCheckerTest.class
})
public class AllTests {

}
