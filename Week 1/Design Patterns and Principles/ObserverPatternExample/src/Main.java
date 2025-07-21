public class Main {
    public static void main(String[] args) {

        // Create a concrete subject (the stock)
        StockMarket appleStock = new StockMarket("AAPL", 150.00);

        // Create concrete observers (the clients)
        Observer mobileApp1 = new MobileApp("MyPhoneApp");
        Observer mobileApp2 = new MobileApp("StockTrackerApp");
        Observer webApp1 = new WebApp("TradingDashboard");

        // Register observers to the subject
        appleStock.register(mobileApp1);
        appleStock.register(mobileApp2);
        appleStock.register(webApp1);

        // Change the stock price, which should notify all registered observers
        appleStock.setPrice(152.50);

        // Deregister one of the observers
        appleStock.deregister(mobileApp2);

        // Change the price again. Only the remaining observers should be notified.
        appleStock.setPrice(155.00);
    }
}