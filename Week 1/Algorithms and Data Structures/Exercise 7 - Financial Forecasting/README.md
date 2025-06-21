✅ 1. Understanding Recursive Algorithms
------------------------------------

### 🔹 What is Recursion?

Recursion is a programming technique where a function **calls itself** to solve smaller sub-problems of the original problem.

### 🔹 When is it useful?

*   When a problem can be **broken down into smaller, similar sub-problems**, recursion offers a **clean and elegant** solution.
    
*   Classic examples: Factorial, Fibonacci, Tree Traversals, etc.
    

✅ 2. Setup: Recursive Method for Future Value
---------------------------------------------

We'll calculate the future value based on:

*   **Initial Value**: P
    
*   **Growth Rate**: r (e.g., 0.05 for 5%)
    
*   **Years (n)**: number of years to forecast
    

### 🔹 Formula:

```
FV(n) = FV(n-1) * (1 + r)
Base Case: FV(0) = P
```

✅ 3. Implementation: Recursive Algorithm
----------------------------------------

### ✅ Java Example:

```java
public class FinancialForecast {

    // Recursive method to calculate future value
    public static double futureValue(double principal, double rate, int years) {
        if (years == 0)
            return principal; // Base case
        return futureValue(principal, rate, years - 1) * (1 + rate); // Recursive step
    }

    public static void main(String[] args) {
        double principal = 1000.0;
        double growthRate = 0.05; // 5%
        int years = 5;

        double result = futureValue(principal, growthRate, years);
        System.out.printf("Future Value after %d years: ₹%.2f\n", years, result);
    }
}
```

✅ 4. Analysis
-------------

### 🔹 Time Complexity:

*   **T(n) = T(n-1) + O(1)** → Linear recursion
    
*   **Time Complexity**: O(n)
    
*   **Space Complexity**: O(n) (due to recursive call stack)
    

### 🔹 Optimization Tip: Use Iteration or Memoization

Recursion can be inefficient for large n due to stack overhead. Consider:

*   **Iterative solution** (uses O(1) space)
    
*   **Memoization** (for overlapping sub-problems like Fibonacci)
    

### ✅ Optimized Iterative Version:

```java
public static double futureValueIterative(double principal, double rate, int years) {
    for (int i = 0; i < years; i++) {
        principal *= (1 + rate);
    }
    return principal;
}
```
