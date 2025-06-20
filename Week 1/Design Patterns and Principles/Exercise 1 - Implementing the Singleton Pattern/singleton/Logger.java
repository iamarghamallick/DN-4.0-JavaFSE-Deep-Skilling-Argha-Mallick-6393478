// Declaring package for organizing the Logger class
package singleton;

public class Logger {
    // Step 1: Declare a private static instance of Logger
    private static Logger instance;

    // Step 2: Make the constructor private so no other class can instantiate it
    private Logger() {
        System.out.println("Logger Initialized.");
    }

    // Step 3: Public static method to get the single instance of Logger
    public static Logger getInstance() {
        // Lazy initialization: create the instance only when it's first requested
        if (instance == null) {
            instance = new Logger();
        }
        return instance; // Return the same instance every time
    }

    // A method to simulate logging
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
