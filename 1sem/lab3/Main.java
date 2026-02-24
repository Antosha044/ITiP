package lab3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();

        Order order1 = new Order("19.10.2025", List.of("Laptop", "Mouse"), "In progress");
        Order order2 = new Order("19.10.2025", List.of("Iphone"), "In delivery");

        manager.addOrder(1001, order1);
        manager.addOrder(1002, order2);

        System.out.println(manager.getOrder(1001));
        manager.updateStatus(1001, "Canceled");
        manager.removeOrder(1002);

        System.out.println(manager.getOrder(1001));

        System.out.println(manager.getOrder(1002));
    }   
}