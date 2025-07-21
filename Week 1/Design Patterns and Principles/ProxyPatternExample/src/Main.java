public class Main {
    public static void main(String[] args) {

        Image image = new ProxyImage("/path/image.png");

        System.out.println("Image object is created. Real image not loaded yet.");

        image.display(); // image will be loaded from the server now
        image.display(); // image is already loaded, so it will not load from server again.
    }
}