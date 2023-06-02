package JavaLabs.FistSem.Lab8;


import JavaLabs.FistSem.Lab5.matrix.UsualMatrix;

import java.util.Random;

import static JavaLabs.FistSem.Lab8.QueenSolver.calcQueenNum;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int size = 1000;
        UsualMatrix a = new UsualMatrix(size, size);
        UsualMatrix b = new UsualMatrix(size, size);

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                a.matrix[i][j] = random.nextInt(100);
                b.matrix[i][j] = random.nextInt(100);
            }
        }

        long startTime = System.currentTimeMillis();
        UsualMatrix c = a.product(a, b);
        long stopTime = System.currentTimeMillis();
        System.out.println("Usual product time: " + (stopTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        ParallelMatrixProduct parallelMultiplier = new ParallelMatrixProduct(4);
        UsualMatrix d = parallelMultiplier.product(a, b);
        stopTime = System.currentTimeMillis();
        System.out.println("Parallel product time: " + (stopTime - startTime) + " ms");

        System.out.println("Matrices are equal: " + c.equals(d));
    }
}
