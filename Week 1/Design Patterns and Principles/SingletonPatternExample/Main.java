// Importing the Logger class from the singleton package
import singleton.Logger;

public class Main {
    public static void main(String[] args) {
        // Step 4: Get the singleton instance and use it
        Logger logger1 = Logger.getInstance(); // First time, instance is created
        logger1.log("First message");

        Logger logger2 = Logger.getInstance(); // Same instance is returned
        logger2.log("Second message");

        // Step 5: Verify both references point to the same object
        System.out.println("Same instance? " + (logger1 == logger2)); // Should print true
    }
}
