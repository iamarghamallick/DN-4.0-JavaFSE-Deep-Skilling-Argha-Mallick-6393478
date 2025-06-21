✅ 1. Understanding Asymptotic Notation
----------------------------------------

### 🔹 Big O Notation:

Big O notation describes the **upper bound of an algorithm’s runtime** in terms of input size n. It helps in analyzing the **scalability** and **efficiency** of algorithms by abstracting away hardware or implementation details.

*   **Example**:
    
    *   A linear search has time complexity O(n) → performance degrades linearly with size.
        
    *   A binary search has O(log n) → performance degrades slowly even for large inputs.
        

### 🔹 Best, Average, and Worst Cases:

*   **Best Case**: The search finds the target early.
    
    *   Linear Search: O(1) (first element matches)
        
    *   Binary Search: O(1) (middle element matches)
        
*   **Average Case**: The search takes place halfway.
    
    *   Linear Search: O(n/2) ≈ O(n)
        
    *   Binary Search: O(log n)
        
*   **Worst Case**: The search checks all options.
    
    *   Linear Search: O(n)
        
    *   Binary Search: O(log n) (log base 2)
        

✅ 2. Setup: Product Class
-------------------------

```java
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}
```

✅ 3. Implementation: Linear & Binary Search
-------------------------------------------

```java
import java.util.Arrays;
import java.util.Comparator;

public class ECommerceSearch {

    // Linear Search by product name
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search by product name (array must be sorted by name)
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);
            if (cmp == 0)
                return products[mid];
            else if (cmp < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] productList = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Footwear"),
            new Product(103, "Book", "Stationery"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Pen", "Stationery")
        };

        // Linear Search Example
        System.out.println("Linear Search Result: " + linearSearch(productList, "Phone"));

        // Sort by product name before binary search
        Arrays.sort(productList, Comparator.comparing(p -> p.productName.toLowerCase()));
        System.out.println("Binary Search Result: " + binarySearch(productList, "Phone"));
    }
}
```

✅ 4. Analysis
-------------

### 🔹 Time Complexity

| Search Type     | Best Case | Average Case | Worst Case |
|-----------------|-----------|--------------|-------------|
| Linear Search   | O(1)      | O(n)         | O(n)        |
| Binary Search   | O(1)      | O(log n)     | O(log n)    |


### 🔹 Comparison

| Criteria               | Linear Search            | Binary Search                         |
|------------------------|--------------------------|----------------------------------------|
| Data Requirement       | Unsorted                 | Must be **sorted**                    |
| Performance (large `n`)| Slower                   | Faster due to `log n` time             |
| Flexibility            | Any condition            | Works best on exact matches (sorted)   |


### 🔹 Which is More Suitable?

*   If product data is **small or changes frequently**, **linear search** is simpler.
    
*   If product data is **large and rarely changes**, **binary search** is far more efficient.
    

✅ **Conclusion**: For **optimized performance in large-scale platforms**, use **binary search** with a **pre-sorted** list or use **hashing or indexing techniques** (e.g., Trie, HashMap, or search engines like ElasticSearch) in real-world apps.
