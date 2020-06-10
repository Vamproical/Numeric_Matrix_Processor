package org.hyperskill.project.medium.processor;

public class OperationOnMatrix {
    private final Matrix matrixA;
    private final Matrix matrixB;

    public OperationOnMatrix(Matrix matrix) {
        this.matrixA = matrix;
        this.matrixB = new Matrix(0, 0);
    }

    public OperationOnMatrix(Matrix matrixA, Matrix matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
    }

    public Matrix addMatrix() {
        int row = matrixA.getRow();
        int column = matrixA.getColumn();
        Matrix result = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                double value = matrixA.getCoordination(i, j) + matrixB.getCoordination(i, j);
                result.setCoordination(i, j, value);
            }
        }
        return result;
    }

    public Matrix multiplyConstant(Matrix matrix, double constant) {
        int row = matrix.getRow();
        int column = matrix.getColumn();
        Matrix result = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                double value = matrix.getCoordination(i, j) * constant;
                result.setCoordination(i, j, value);
            }
        }
        return result;
    }

    public Matrix multiplyMatrices() {
        Matrix result = new Matrix(matrixA.getRow(), matrixB.getColumn());
        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixB.getColumn(); j++) {
                double value = 0;
                for (int k = 0; k < matrixA.getColumn(); k++) {
                    value += matrixA.getCoordination(i, k) * matrixB.getCoordination(k, j);
                }
                result.setCoordination(i, j, value);
            }
        }
        return result;
    }

    public Matrix transposeMain(Matrix matrix) {
        int row = matrix.getRow();
        int column = matrix.getColumn();
        Matrix result = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result.setCoordination(i, j, matrix.getCoordination(j, i));
            }
        }
        return result;
    }

    public Matrix transposeSide() {
        int row = matrixA.getRow();
        int column = matrixA.getColumn();
        Matrix result = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i; j++) {
                result.setCoordination(i, j, matrixA.getCoordination(row - j - 1, row - i - 1));
                result.setCoordination(row - j - 1, row - i - 1, matrixA.getCoordination(i, j));
            }
        }
        return result;
    }

    public Matrix transposeVertical() {
        int row = matrixA.getRow();
        int column = matrixA.getColumn();
        Matrix result = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                double temp = matrixA.getCoordination(i, j);
                result.setCoordination(i, column - j - 1, temp);
                temp = matrixA.getCoordination(i, column - j - 1);
                result.setCoordination(i, j, temp);
            }
        }
        return result;
    }

    public Matrix transposeHorizontal() {
        int row = matrixA.getRow();
        int column = matrixA.getColumn();
        Matrix result = new Matrix(row, column);
        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                double temp = matrixA.getCoordination(i, j);
                result.setCoordination(row - i - 1, j, temp);
                temp = matrixA.getCoordination(row - i - 1, j);
                result.setCoordination(i, j, temp);
            }
        }
        return result;
    }

    public double determinant(Matrix matrix1) {
        double result = 0;
        if (matrix1.getRow() == 1) {
            return matrixA.getCoordination(0, 0);
        }
        if (matrix1.getRow() == 2) {
            result = matrix1.getCoordination(0, 0) * matrix1.getCoordination(1, 1) - matrix1.getCoordination(0, 1) * matrix1.getCoordination(1, 0);
            return result;
        }
        for (int i = 0; i < matrix1.getColumn(); i++) {
            result += Math.pow(-1, i) * matrix1.getCoordination(0, i)
                    * determinant(minor(matrix1, 0, i));
        }
        return result;
    }

    public void determinant() {
        System.out.println(determinant(matrixA));
    }

    private static Matrix minor(Matrix matrix, int row, int col) {
        Matrix minor = new Matrix(matrix.getRow() - 1, matrix.getColumn() - 1);
        for (int i = 0; i < matrix.getColumn(); i++) {
            for (int j = 0; i != row && j < matrix.getColumn(); j++) {
                if (j != col) {
                    minor.setCoordination(i < row ? i : i - 1, j < col ? j : j - 1, matrix.getCoordination(i, j));
                }
            }
        }
        return minor;
    }

    public Matrix inverseMatrix() {
        Matrix matrix = new Matrix(matrixA.getRow(), matrixA.getColumn());
        for (int i = 0; i < matrix.getRow(); i++) {
            for (int j = 0; j < matrix.getColumn(); j++) {
                matrix.setCoordination(i, j, Math.pow(-1, i + j) * determinant(minor(matrixA, i, j)));
            }
        }
        double inverseDetermination = 1.0 / determinant(matrixA);
        matrix = transposeMain(matrix);
        matrix = multiplyConstant(matrix, inverseDetermination);
        return matrix;
    }
}
