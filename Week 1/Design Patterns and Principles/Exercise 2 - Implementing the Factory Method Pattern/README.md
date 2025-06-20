### ✅ **Exercise 2: Factory Method Pattern – Concepts Explained**

### 🔷 **What is the Factory Method Pattern?**

The **Factory Method Pattern** allows a class to **delegate the instantiation of its objects to subclasses**. Instead of calling a constructor directly, you use a method (createDocument() in this case) that returns an object of a type that implements a common interface or base class.

### 🔑 **Key Concepts Used**

#### 1\. **Document Interface / Abstract Class**

*   This defines a **standard interface** for all document types (e.g., open() method).
    
*   All concrete document classes implement or extend this interface/class.
    

```java
public interface Document {     
    void open();  
}
```

#### 2\. **Concrete Document Classes**

*   These are the actual classes like WordDocument, PdfDocument, and ExcelDocument.
    
*   They implement the Document interface and provide their own logic for open().
    

```java
public class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document...");
    }
}
```

(Similar for PdfDocument, ExcelDocument)

#### 3\. **Abstract Factory Class**

*   This class (DocumentFactory) declares the method createDocument() without defining it.
    
*   It allows subclasses to define the actual instantiation logic.
    

```java
public abstract class DocumentFactory {
    public abstract Document createDocument();
}
```

#### 4\. **Concrete Factory Classes**

*   These extend DocumentFactory and implement createDocument() to return specific document types.
    
*   For example, PdfDocumentFactory returns a PdfDocument.
    

```java
public class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}
```

#### 5\. **Main Class (Client Code)**

*   It decides which factory to use and calls createDocument() on it.
    
*   The actual document type is **decoupled** from the main class.
    

```java
DocumentFactory factory = new WordDocumentFactory();
Document doc = factory.createDocument();
doc.open();
```

### 📌 **Why Use the Factory Method Pattern?**

*   **Loose Coupling**: The client code is not tied to specific implementations.
    
*   **Open/Closed Principle**: You can add new document types without modifying existing code.
    
*   **Cleaner Code**: All creation logic is in one place (the factory), not spread across the app.
    

### 🧠 Summary Table

| Concept                   | Purpose                                               |
|---------------------------|--------------------------------------------------------|
| Interface / Abstract Class| Defines a standard contract for all document types     |
| Concrete Classes          | Implement different types of documents                 |
| Abstract Factory          | Declares the factory method                            |
| Concrete Factories        | Implement factory method for specific documents        |
| Client Code (Main Class)  | Uses factories to create objects without knowing details|
