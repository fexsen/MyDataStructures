package JavaLabs.FistSem.Lab5.matrix;

public class SquareMatrix extends UsualMatrix {

    public SquareMatrix(int dim) throws MatrixException {
        if(dim <= 0){
            throw new MatrixException("Incorrect matrix size");
        }
        this.rows = dim;
        this.columns = dim;
        this.matrix  = new int[rows][columns];

        for(int i = 0; i < dim; i++) {
            for(int j = 0; j < dim; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public SquareMatrix sum(SquareMatrix m) throws MatrixException{

        if(m.rows != rows){
            throw new MatrixException("Matrix size is not equal");
        }
        int d = this.rows;
        SquareMatrix res = new SquareMatrix(d);

        for(int i = 0; i < d; i++){
            for(int j = 0; j < d; j++){
                res.setValue(i, j, (matrix[i][j] + m.getValue(i, j)));
            }
        }

        return res;
    }
}
