package JavaLabs.FistSem.Lab5.matrix;


import java.util.Arrays;

public class UsualMatrix implements IMatrix<UsualMatrix>{
    public int rows;
    public int columns;
    public int[][] matrix;

    public UsualMatrix() throws MatrixException{
        this.rows    = 1;
        this.columns = 1;
        this.matrix  = new int[rows][columns];
    }

    public UsualMatrix(int rows, int columns) throws MatrixException {

        if(rows <= 0 || columns <= 0){
            throw new MatrixException("Incorrect matrix size");
        }

        this.rows    = rows;
        this.columns = columns;
        this.matrix  = new int[rows][columns];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public int getValue(int r, int c) throws MatrixException{
        if(r < 0 || c < 0){
            throw new MatrixException("Negative index");
        }
        return matrix[r][c];
    }
    public void setValue(int r, int c, int value) throws MatrixException{
        if(r < 0 || c < 0){
            throw new MatrixException("Negative index");
        }
        matrix[r][c] = value;
    }


    public UsualMatrix sum(UsualMatrix matrix1, UsualMatrix matrix12) throws MatrixException { //вычисляет сумму матриц

        if(matrix1.rows != matrix12.rows || matrix1.columns != matrix12.columns){
            throw new MatrixException("Matrix size is not equal");
        }

        UsualMatrix matrix = new UsualMatrix(rows, columns);

        for(int i = 0; i < matrix1.rows; i++) {
            for(int j = 0; j < matrix1.columns; j++) {
                matrix.matrix[i][j] = matrix1.matrix[i][j] + matrix12.matrix[i][j];
            }
        }

        return matrix;
    }

    public UsualMatrix product(UsualMatrix matrix1, UsualMatrix matrix12) throws MatrixException{ //вычисляет произведение матриц

        int n;
        n = Math.max(matrix1.rows, matrix1.columns);

        UsualMatrix matrix = new UsualMatrix(matrix1.rows, matrix1.rows);

        for(int i = 0; i < matrix1.rows; i++) {
            for(int j = 0; j < matrix1.rows; j++) {
                for(int k = 0; k < n; k++) {
                    matrix.matrix[i][j] += matrix1.matrix[i][k]* matrix12.matrix[k][j];
                }
            }
        }

        return matrix;
    }

    @Override
    public String toString (){
        return Arrays.deepToString(this.matrix);
    }


    public boolean equals(UsualMatrix matr) throws MatrixException{
        if(matr.rows != rows || matr.columns != columns){
            return false;
        }else {
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < columns; j++){
                    if(matr.getValue(i, j) != this.matrix[i][j]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
