public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // In a real application, this would query a database.
        // Here, we are just returning a dummy customer for demonstration.
        System.out.println("Searching for customer with ID: " + id + " in the database");
        return new Customer(id, "Argha Mallick");
    }
}