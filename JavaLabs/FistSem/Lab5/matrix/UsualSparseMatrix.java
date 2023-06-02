package JavaLabs.FistSem.Lab5.matrix;

public class UsualSparseMatrix {
    private final int rows;
    private final int columns;

    public UsualSparseMatrix(int r, int c) {
        rows = r;
        columns = c;
    }

    private Node first = null;

    private static class Node {
        int row;
        int col;
        int data;
        Node next;
    }

    public int getValue(int r, int c) {
        Node temp = first;

        while (temp != null) {
            if (temp.row == r && temp.col == c) {
                return temp.data;
            }
            temp = temp.next;
        }

        return 0;
    }

    public void setValue(int r, int c, int value) {
        Node temp = first;
        Node nd;

        if (temp == null) {
            temp = new Node();
            temp.row = r;
            temp.col = c;
            temp.data = value;
            temp.next = null;
            first = temp;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            nd = new Node();
            nd.row = r;
            nd.col = c;
            nd.data = value;
            nd.next = null;
            temp.next = nd;
        }
    }

    public UsualSparseMatrix sum(UsualSparseMatrix matrix1, UsualSparseMatrix matrix12) {
        if (matrix1.rows != matrix12.rows || matrix1.columns != matrix12.columns) {
            throw new BadRangeMatrixException("Matrices range not equal");
        }
        Node temp1 = matrix1.first;
        Node temp2 = matrix12.first;
        UsualSparseMatrix res = new UsualSparseMatrix(rows, columns);


        while (temp1 != null || temp2 != null) {
            if (temp1 == null) {
                res.setValue(temp2.row, temp2.col, temp2.data);
            } else if (temp2 == null) {
                res.setValue(temp1.row, temp1.col, temp1.data);
            } else if (temp1.col == temp2.col && temp1.row == temp2.row) {
                res.setValue(temp1.row, temp1.col, temp1.data + temp2.data);
            } else {
                res.setValue(temp1.row, temp1.col, temp1.data);
                res.setValue(temp2.row, temp2.col, temp2.data);
            }
            if (temp1 != null)
                temp1 = temp1.next;
            if (temp2 != null)
                temp2 = temp2.next;
        }
        return res;
    }

    public UsualSparseMatrix product(UsualSparseMatrix thi, UsualSparseMatrix other) {
        if (columns != other.rows) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication");
        }
        UsualSparseMatrix result = new UsualSparseMatrix(rows, other.columns);
        Node currentRow = first;
        while (currentRow != null) {
            Node currentCol = other.first;
            while (currentCol != null) {
                if (currentRow.col == currentCol.row) {
                    result.setValue(currentRow.row, currentCol.col, currentRow.data * currentCol.data);
                }
                currentCol = currentCol.next;
            }
            currentRow = currentRow.next;
        }
        return result;
    }
}
