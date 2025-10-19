package lab3;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String date;
    private List<String> items;
    private String status;

    public Order(String date, List<String> items, String status) {
        this.date = date;
        this.items = new ArrayList<>(items);
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public List<String> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date='" + date + '\'' +
                ", items=" + items +
                ", status='" + status + '\'' +
                '}';
    }
}


