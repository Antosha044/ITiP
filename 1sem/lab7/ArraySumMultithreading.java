public class ArraySumMultithreading {

    static class SumTask implements Runnable {

        private int[] array;
        private int start;
        private int end;
        private int result; 

        public SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            result = sum;
        }

        public int getResult() {
            return result;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        int[] array = {1, 2, 3, 4, 5, 6};

        int middle = array.length / 2;

        SumTask task1 = new SumTask(array, 0, middle);
        SumTask task2 = new SumTask(array, middle, array.length);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        int totalSum = task1.getResult() + task2.getResult();

        System.out.println("Sum " + totalSum);
    }
}
