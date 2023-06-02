package JavaLabs.FistSem.Lab2;

public class Main {
    public static void main(String[] args) {


        Matrix matr = new Matrix(2);
        matr.setValue(0, 1, 1);
        matr.setValue(1, 0, 1);
        matr.setValue(1, 1, 0);
        System.out.println("Current Matrix: ");
        System.out.println(matr.toString() + " Power 1");

        Matrix matrhelp = matr;
        for(int i = 2; i <= 10; i++){
            matr = matrhelp.product(matr);
            System.out.println("Current Matrix: ");
            System.out.println(matr.toString() + " Power " + i);
        }


    }

}
