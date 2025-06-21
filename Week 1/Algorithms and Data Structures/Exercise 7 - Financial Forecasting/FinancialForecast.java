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
        System.out.printf("Future Value after %d years: Rs. %.2f\n", years, result);
    }
}
