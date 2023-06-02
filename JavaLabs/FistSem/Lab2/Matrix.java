package JavaLabs.FistSem.Lab2;
import java.util.Arrays;

public class Matrix {
    private int [][] matrix;
    private final int dim;

    public int getValue(int r, int c){
        return this.matrix[r][c];
    }

    public void setValue(int r, int c, int value){
        this.matrix[r][c] = value;
    }

    public Matrix(int d){
        this.matrix = new int[d][d];
        this.dim = d;
        for(int i = 0; i < d; i++){
            for(int j = 0; j < d; j++){
                if(i == j){
                    this.matrix[i][j] = 1;
                }
                else{
                    this.matrix[i][j] = 0;
                }
            }
        }
    }

    @Override
    public String toString (){
        return Arrays.deepToString(this.matrix);
    }

    public Matrix sum(Matrix m){
        int d = this.dim;
        Matrix res = new Matrix(d);

        for(int i = 0; i < d; i++){
            for(int j = 0; j < d; j++){
                res.setValue(i, j, (matrix[i][j] + m.getValue(i, j)));
            }
        }

        return res;
    }
    public Matrix product(Matrix m){
        int d = this.dim;
        Matrix res = new Matrix(d);

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                int tmp = res.getValue(i, j);
                for (int k = 0; k < d; k++) {
                    res.setValue(i, j,tmp + this.matrix[i][k] * m.getValue(k, j));
                }
            }
        }

        return res;
    }

}
