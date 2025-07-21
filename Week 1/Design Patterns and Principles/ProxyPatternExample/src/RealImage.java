public class RealImage implements Image {

    private String location;

    public RealImage(String location) {
        this.location = location;
        loadFromServer(location);
    }

    private void loadFromServer(String location) {
        System.out.println("Loading image from: " + location);
    }

    @Override
    public void display() {
        System.out.println("Displaying image from location: " + location);
    }
}
