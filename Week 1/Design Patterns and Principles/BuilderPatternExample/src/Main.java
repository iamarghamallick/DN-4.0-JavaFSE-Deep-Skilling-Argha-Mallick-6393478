public class Main {

    public static void main(String[] args) {

        // with only required parameters
        Computer c1 = new Computer.ComputerBuilder("Intel Core I3", "8 GB").build();
        System.out.println(c1);

        // with optional parameters also
        Computer c2 = new Computer.ComputerBuilder("Intel Core I5", "16 GB").storage("1 TB").build();
        System.out.println(c2);
    }
}