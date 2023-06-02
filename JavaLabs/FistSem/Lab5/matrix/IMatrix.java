package JavaLabs.FistSem.Lab5.matrix;

public interface IMatrix <T> {

    int getValue(int r, int c);
    void setValue(int r, int c, int value);
    T sum(T matrix1, T matrix12);
    T product(T matrix1, T matrix12);

}
