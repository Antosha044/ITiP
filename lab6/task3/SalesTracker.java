import java.util.*;

public class SalesTracker {
    private Map<Product, Integer> sales = new HashMap<>();

    public void addSale(Product product) {
        sales.put(product, sales.getOrDefault(product, 0) + 1);
    }

    public void printSales() {
        System.out.println("Sold products:");
        for (Map.Entry<Product, Integer> entry : sales.entrySet()) {
            System.out.println(entry.getKey().getName() + " - " + entry.getValue());
        }
    }

    public double totalSales() {
        double sum = 0;
        for (Map.Entry<Product, Integer> entry : sales.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }
        return sum;
    }

    public Product mostPopular() {
        Product popular = null;
        int max = 0;
        for (Map.Entry<Product, Integer> entry : sales.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                popular = entry.getKey();
            }
        }
        return popular;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        Product apple = new Product("Apple", 1.0);
        Product banana = new Product("Banana", 2.0);

        tracker.addSale(apple);
        tracker.addSale(apple);
        tracker.addSale(banana);

        tracker.printSales();
        System.out.println("Sum: " + tracker.totalSales());
        System.out.println("Most popular " + tracker.mostPopular().getName());
    }
}
