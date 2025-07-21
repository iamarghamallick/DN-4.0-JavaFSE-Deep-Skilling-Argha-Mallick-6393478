public class Main {
    public static void main(String[] args) {

        // 1. Create the dependency object (the concrete repository).
        CustomerRepository repository = new CustomerRepositoryImpl();

        // 2. Create the dependent object (the service) and inject the dependency.
        //    We are passing the repository object into the service's constructor.
        CustomerService service = new CustomerService(repository);

        // 3. Use the service to perform an action.
        String customerId = "6393478";
        Customer customer = service.getCustomerDetails(customerId);

        // 4. Display the result.
        System.out.println("Found Customer Details:");
        System.out.println(customer);
    }
}