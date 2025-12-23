import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MaxInMatrix {
    
    static class MaxTask implements Callable<Integer> {
        private int[][] matrix;
        private int startRow;
        private int endRow;

        public MaxTask(int[][] matrix, int startRow, int endRow) {
            this.matrix = matrix;
            this.startRow = startRow;
            this.endRow = endRow;
        }

        @Override
        public Integer call() {
            int max = Integer.MIN_VALUE;

            for (int i = startRow; i < endRow; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] > max) {
                        max = matrix[i][j];
                    }
                }
            }
            return max;
        }
    }

    public static void main(String[] args) throws Exception {

        int[][] matrix = {
                {1, 5, 3},
                {9, 2, 8},
                {4, 6, 7},
                {0, 11, 10}
        };

        int numberOfThreads = 2;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        List<Future<Integer>> results = new ArrayList<>();

        int rowsPerTask = matrix.length / numberOfThreads;
        int startRow = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            int endRow = (i == numberOfThreads - 1) ? matrix.length : startRow + rowsPerTask;

            MaxTask task = new MaxTask(matrix, startRow, endRow);
            Future<Integer> future = executor.submit(task);
            results.add(future);

            startRow = endRow;
        }

        int globalMax = Integer.MIN_VALUE;

        for (Future<Integer> future : results) {
            int localMax = future.get();
            if (localMax > globalMax) {
                globalMax = localMax;
            }
        }

        executor.shutdown();

        System.out.println("Max in matrix " + globalMax);
    }
}
