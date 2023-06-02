package JavaLabs.FistSem.Lab8;
import JavaLabs.FistSem.Lab5.matrix.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelMatrixProduct {
    private int numberOfThreads;

    public ParallelMatrixProduct(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
    }

    public UsualMatrix product(UsualMatrix matrix1, UsualMatrix matrix2) throws InterruptedException {
        if (matrix1.columns != matrix2.rows) {
            throw new IllegalArgumentException("Matrices cannot be multiplied");
        }

        int rows = matrix1.rows;
        int columns = matrix2.columns;
        int commonDimension = matrix1.columns;

        UsualMatrix result = new UsualMatrix(rows, columns);

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                MatrixTask task = new MatrixTask(matrix1, matrix2, result, i, j, commonDimension);
                executor.execute(task);
            }
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);

        return result;
    }

    private static class MatrixTask implements Runnable {
        private UsualMatrix matrix1;
        private UsualMatrix matrix2;
        private UsualMatrix result;
        private int row;
        private int column;
        private int commonDimension;

        public MatrixTask(UsualMatrix matrix1, UsualMatrix matrix2, UsualMatrix result,
                          int row, int column, int commonDimension) {
            this.matrix1 = matrix1;
            this.matrix2 = matrix2;
            this.result = result;
            this.row = row;
            this.column = column;
            this.commonDimension = commonDimension;
        }

        @Override
        public void run() {
            int value = 0;
            for (int i = 0; i < commonDimension; i++) {
                value += matrix1.getValue(row, i) * matrix2.getValue(i, column);
            }
            try {
                result.setValue(row, column, value);
            } catch (MatrixException e) {
                e.printStackTrace();
            }
        }
    }
}
