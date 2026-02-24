package lab3;

import java.util.HashMap;

public class OrderManager {
    private HashMap<Integer, Order> orders;

    public OrderManager() {
        orders = new HashMap<>();
    }
    
    public void addOrder(int orderNumber, Order order) {
        orders.put(orderNumber, order);
    }

    public Order getOrder(int orderNumber) {
        return orders.get(orderNumber);
    }

    public void removeOrder(int orderNumber) {
        orders.remove(orderNumber);
    }

    public void updateStatus(int orderNumber, String newStatus) {
        Order order = orders.get(orderNumber);

        if (order != null) {
            order.setStatus(newStatus);
        } else {
            System.out.println("Order " + orderNumber + " is not found");
        }
    }   
}
