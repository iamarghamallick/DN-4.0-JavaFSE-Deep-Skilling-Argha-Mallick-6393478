import singleton.Logger;

public class Main {

    public static void main(String[] args) {

        Logger l1 = Logger.getInstance();
        l1.log("Hello");

        Logger l2 = Logger.getInstance();
        l2.log("Argha!");

        System.out.printf("Both instances are: " + (l1 == l2 ? "same" : "different"));
    }
}
