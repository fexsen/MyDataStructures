package JavaLabs.FistSem.Lab5;

import JavaLabs.FistSem.Lab5.matrix.*;


public class Main {
        public static void main(String[] args) {


            /*
            UsualMatrix matr = new UsualMatrix(2, 2);
            matr.setValue(0, 1, 1);
            matr.setValue(1, 0, 1);
            matr.setValue(1, 1, 1);
            System.out.println("Current Matrix: ");
            System.out.println(matr.toString() + " Power 1");

            UsualMatrix matrhelp = matr;
            for(int i = 2; i <= 10; i++){
                matr = matrhelp.product(matrhelp, matr);
                System.out.println("Current Matrix: ");
                System.out.println(matr.toString() + " Power " + i);
            }
            */

            UsualSparseMatrix m1 = new UsualSparseMatrix(10, 10);
            m1.setValue(0, 3, 9);
            m1.setValue(0, 5, 10);
            m1.setValue(0, 1, 10);
            m1.setValue(0, 7, 11);

            UsualSparseMatrix m2 = new UsualSparseMatrix(10, 10);
            m2.setValue(0, 3, 9);
            m2.setValue(0, 5, 10);
            m2.setValue(0, 1, 10);


            m1 = m1.sum(m1, m2);

            UsualMatrix m1u = new UsualMatrix(10, 10);
            m1u.setValue(0, 3, 9);
            m1u.setValue(0, 5, 10);
            m1u.setValue(0, 1, 10);
            m1u.setValue(0, 7, 11);

            UsualMatrix m2u = new UsualMatrix(10, 10);
            m2u.setValue(0, 3, 9);
            m2u.setValue(0, 5, 10);
            m2u.setValue(0, 1, 10);


            m1u = m1u.sum(m1u, m2u);

            if(m1.getValue(0, 3) == m1u.getValue(0, 3)){
                System.out.println("Matrices are equal");
            }

            UsualMatrix mat = new UsualMatrix(1000, 1000);
            UsualSparseMatrix mat2 = new UsualSparseMatrix(1000, 1000);
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    if (i % 99 == 0 && j % 98 == 0) {
                        mat.setValue(i, j, (i + j) * 2);
                    }
                }
            }
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
                    if (i % 99 == 0 && j % 98 == 0) {
                        mat2.setValue(i, j, (i + j) * 2);
                    }
                }
            }

            long startTime = System.currentTimeMillis();
            mat = mat.product(mat, mat);
            long stopTime = System.currentTimeMillis();
            System.out.println("Usual product time: " + (stopTime - startTime) + " ms");

            startTime = System.currentTimeMillis();
            mat2 = mat2.product(mat2, mat2);
            stopTime = System.currentTimeMillis();
            System.out.println("Sparse product time: " + (stopTime - startTime) + " ms");

            if(mat.getValue(99, 98) == mat2.getValue(99, 98)){

                System.out.println("Matrices are equal");

            } else {
                System.out.println("Matrices are not equal");
            }
        }

}
