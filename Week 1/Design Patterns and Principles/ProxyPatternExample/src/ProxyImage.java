public class ProxyImage implements Image {

    private RealImage realImage;
    private String location;

    public ProxyImage(String location) {
        this.location = location;
    }

    @Override
    public void display() {
        if(realImage == null) { // lazy initialization
            realImage = new RealImage(location);
        }
        realImage.display();
    }
}
