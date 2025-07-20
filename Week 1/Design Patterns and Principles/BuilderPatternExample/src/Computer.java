public class Computer {

    private final String cpu;
    private final String ram;
    private final String storage;

    private Computer(ComputerBuilder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
    }

    @Override
    public String toString() {
        return "Computer Specifications: \n" +
                "  CPU: " + cpu + "\n" +
                "  RAM: " + ram + "\n" +
                "  Storage: " + storage + "\n";
    }

    public static class ComputerBuilder {

        // required parameters
        private final String cpu;
        private final String ram;

        // optional parameters
        private String storage = "512 GB";

        public ComputerBuilder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public ComputerBuilder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
