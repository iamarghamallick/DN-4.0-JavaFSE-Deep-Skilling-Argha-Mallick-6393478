import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double price;

    public StockMarket(String stockName, double initialPrice) {
        this.observers = new ArrayList<>();
        this.stockName = stockName;
        this.price = initialPrice;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        System.out.println("Stock Price for " + stockName + " changed to $" + this.price);
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
        System.out.println(observer.getClass().getSimpleName() + " is now observing " + stockName);
    }

    @Override
    public void deregister(Observer observer) {
        observers.remove(observer);
        System.out.println(observer.getClass().getSimpleName() + " has stopped observing " + stockName);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}
