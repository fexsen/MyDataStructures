#include <iostream>
using namespace std;

template <typename T>
class Matrix {
public:
	Matrix(size_t r, size_t c) {
		row = r;
		column = c;
		matrix = new T*[row];
		for (int i = 0; i < row; i++) {
			matrix[i] = new T[column];
		}
	}
	Matrix(const Matrix& m) {
		row = m.row;
		column = m.column;
		matrix = m.matrix;
	}
	~Matrix() {
		for (int i = 0; i < row; i++) {
			delete[] matrix[i];
		}
		delete[] matrix;
	}

	size_t rows() {
		return row;
	}
	size_t columns() {
		return column;
	}

	void print() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				cout << matrix[i][j] << ' ';
			}
			cout << endl;
		}
	}

	void set(size_t r, size_t c, T value) {
		if (r < 0 || r >= row || c < 0 || c >= column) {
			throw value;
		}
		matrix[r][c] = value;
	}
	T get(size_t r, size_t c) {
		if (r < 0 || r >= row || c < 0 || c >= column) {
			throw column;
		}
		return matrix[r][c];
	}

	Matrix sum(const Matrix& m) {
		if (row != m.row || column != m.column) {
			throw 0;
		}
		Matrix<T> summ(row, column);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				summ.matrix[i][j] = matrix[i][j] + m.matrix[i][j];
			}
		}
		return summ;
	}

	Matrix operator=(const Matrix& m) {
		row = m.row;
		column = m.column;
		matrix = m.matrix;
		return *this;
	}
private:
	size_t row = 0;
	size_t column = 0;
	T** matrix = nullptr;
};	

int main()
{
	Matrix<int> matr1(3, 4);
	Matrix<int> matr2(3, 4);
	matr1.set(1, 2, 98);
	cout << matr1.get(1, 2) << endl << endl;
	for (int i = 0; i < matr1.rows(); i++) {
		for (int j = 0; j < matr1.columns(); j++) {
			matr1.set(i, j, i+j);
		}
	}
	matr1.print();
	cout << endl;
	for (int i = 0; i < matr2.rows(); i++) {
		for (int j = 0; j < matr2.columns(); j++) {
			matr2.set(i, j, i-j);
		}
	}
	matr2.print();
	cout << endl;
	Matrix<int> summatr = matr1.sum(matr2);
	summatr.print();
}
