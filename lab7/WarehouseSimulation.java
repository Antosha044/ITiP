import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WarehouseSimulation {

    static class Warehouse {

        private Queue<Integer> goods; 
        private int currentWeight = 0;

        private final int MAX_WEIGHT = 150;

        private Lock lock = new ReentrantLock();
        private Condition canLoad = lock.newCondition();

        public Warehouse(List<Integer> goodsList) {
            this.goods = new LinkedList<>(goodsList);
        }

        public void loadGoods(String loaderName) throws InterruptedException {
            lock.lock();
            try {
                while (goods.isEmpty()) {
                    return; 
                }

                int weight = goods.peek();

                while (currentWeight + weight > MAX_WEIGHT) {
                    System.out.println(loaderName + " is wait, current weight: " + currentWeight);
                    canLoad.await();
                }

                goods.poll();
                currentWeight += weight;

                System.out.println(loaderName + " pick up " + weight +
                        " kg, current weight: " + currentWeight);

                if (currentWeight == MAX_WEIGHT) {
                    sendTruck();
                }

            } finally {
                lock.unlock();
            }
        }

        private void sendTruck() throws InterruptedException {
            System.out.println("The truck is gone");
            currentWeight = 0;

            canLoad.signalAll(); 
        }
    }

    static class Loader implements Runnable {

        private Warehouse warehouse;
        private String name;

        public Loader(Warehouse warehouse, String name) {
            this.warehouse = warehouse;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    warehouse.loadGoods(name);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {

        List<Integer> goods = List.of(
                40, 30, 20, 60, 50, 30, 20, 40, 10, 50
        );

        Warehouse warehouse = new Warehouse(goods);

        Thread l1 = new Thread(new Loader(warehouse, "Loader 1"));
        Thread l2 = new Thread(new Loader(warehouse, "Loader 2"));
        Thread l3 = new Thread(new Loader(warehouse, "Loader 3"));

        l1.start();
        l2.start();
        l3.start();
    }
}
