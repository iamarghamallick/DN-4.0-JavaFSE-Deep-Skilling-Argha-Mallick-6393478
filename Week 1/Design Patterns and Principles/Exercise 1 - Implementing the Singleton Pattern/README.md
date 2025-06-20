✅ **Exercise 1: Singleton Pattern**
-----------------------------------

### 🔷 **What is the Singleton Pattern?**

The Singleton Pattern ensures that **only one instance** of a class is created **throughout the lifecycle of the application**, and it provides a **global access point** to that instance.

### 🔑 **Key Concepts Used**

### 1\. **Private Static Instance**

```java
private static Logger instance;
```

*   This holds the **single object** of the Logger class.
    
*   Declared static so it's **shared across all calls** to Logger.getInstance().
    
*   private so no one outside the class can directly access or modify it.
    

### 2\. **Private Constructor**

```
private Logger() {
    System.out.println("Logger Initialized.");
}
```

*   Constructor is marked private to **prevent other classes** from creating new objects using new Logger().
    

### 3\. **Public Static Method for Access**

```
public static Logger getInstance() {      
    if (instance == null) {          
        instance = new Logger();      
    }      
    return instance;  
}
```

*   This method is how other classes access the Logger.
    
*   Uses **lazy initialization**: creates the object **only when needed** (first call).
    
*   Always returns the **same instance** afterward.
    

### 4\. **Global Access & Reusability**

```java
Logger logger1 = Logger.getInstance();  Logger logger2 = Logger.getInstance();
```

*   Both logger1 and logger2 point to the **same object in memory**.
    
*   This ensures **consistent logging** behavior across the application.
    

### 5\. **Identity Check**

```java
System.out.println(logger1 == logger2);
```

*   Verifies that both references are to the **same instance**.
    

### 📌 **Why Use Singleton for Logging?**

*   You don’t want multiple logger objects with different configurations.
    
*   Logging should be **consistent**, centralized, and accessible **globally**.
    
*   Ensures better **resource usage** and **debugging** support.
    

### 🧠 Summary Table

| Concept              | Purpose                                              |
|----------------------|------------------------------------------------------|
| `private static`     | Holds the only instance                              |
| `private constructor`| Prevents external instantiation                      |
| `public static`      | Provides access to the singleton instance            |
| Lazy Initialization  | Delays object creation until it is actually needed   |
| Identity Check       | Verifies only one object exists                      |
