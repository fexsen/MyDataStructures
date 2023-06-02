package JavaLabs.FistSem.Lab5.matrix;
import java.util.*;

class Element implements Comparable<Element> {
        int i, j;

        Element(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int compareTo(Element e) {
            if (i < e.i) return -1;
            if (i > e.i) return 1;
            if (j < e.j) return -1;
            if (j > e.j) return 1;
            return 0;
        }

        public boolean equals(Object o) {
            if (!(o instanceof Element)) return false;
            Element e = (Element) o;
            return i == e.i && j == e.j;
        }

        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    public class SparseMatrix {
        TreeMap<Element, Integer> map;
        int rows, cols;

        public SparseMatrix(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
            map = new TreeMap<>();
        }

        public void setValue(int i, int j, int value) {
            if (i < 0 || i >= rows || j < 0 || j >= cols) {
                throw new IndexOutOfBoundsException();
            }
            Element e = new Element(i, j);
            if (value != 0) {
                map.put(e, value);
            } else {
                map.remove(e);
            }
        }

        public int getValue(int i, int j) {
            if (i < 0 || i >= rows || j < 0 || j >= cols) {
                throw new IndexOutOfBoundsException();
            }
            Element e = new Element(i, j);
            return map.getOrDefault(e, 0);
        }

        public SparseMatrix sum(SparseMatrix other) {
            if (rows != other.rows || cols != other.cols) {
                throw new IllegalArgumentException("The matrices must have the same dimensions.");
            }
            SparseMatrix result = new SparseMatrix(rows, cols);
            for (Element e : map.keySet()) {
                int value = map.get(e) + other.getValue(e.i, e.j);
                result.setValue(e.i, e.j, value);
            }
            for (Element e : other.map.keySet()) {
                if (!map.containsKey(e)) {
                    result.setValue(e.i, e.j, other.getValue(e.i, e.j));
                }
            }
            return result;
        }

        public SparseMatrix product(SparseMatrix other) {
            if (cols != other.rows) {
                throw new IllegalArgumentException("The number of columns in the first matrix must be equal to the number of rows in the second matrix.");
            }
            SparseMatrix result = new SparseMatrix(rows, other.cols);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < other.cols; j++) {
                    int sum = 0;
                    for (int k = 0; k < cols; k++) {
                        sum += getValue(i, k) * other.getValue(k, j);
                    }
                    result.setValue(i, j, sum);
                }
            }
            return result;
        }

        public void print() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(getValue(i, j) + " ");
                }
                System.out.println();
            }
        }
    }
