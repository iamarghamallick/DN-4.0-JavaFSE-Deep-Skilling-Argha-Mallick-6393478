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
