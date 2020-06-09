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

    public void addMatrix() {
        int row = matrixA.getRow();
        int column = matrixA.getColumn();
        Matrix result = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                double value = matrixA.getCoordination(i, j) + matrixB.getCoordination(i, j);
                result.setCoordination(i, j, value);
            }
        }
        System.out.println("The add result is:");
        result.printMatrix();
    }

    public void multiplyConstant(double constant) {
        int row = matrixA.getRow();
        int column = matrixA.getColumn();
        Matrix result = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                double value = matrixA.getCoordination(i, j) * constant;
                result.setCoordination(i, j, value);
            }
        }
        System.out.println("The multiplication to a constant result is:");
        result.printMatrix();
    }

    public void multiplyMatrices() {
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
        System.out.println("The multiplication is:");
        result.printMatrix();
    }

    public void transposeMain() {
        int row = matrixA.getRow();
        int column = matrixA.getColumn();
        Matrix result = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result.setCoordination(i, j, matrixA.getCoordination(j, i));
            }
        }
        result.printMatrix();
    }

    public void transposeSide() {
        int row = matrixA.getRow();
        int column = matrixA.getColumn();
        Matrix result = new Matrix(row, column);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row - i; j++) {
                result.setCoordination(i, j, matrixA.getCoordination(row - j - 1, row - i - 1));
                result.setCoordination(row - j - 1, row - i - 1, matrixA.getCoordination(i, j));
            }
        }
        result.printMatrix();
    }

    public void transposeVertical() {
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
        result.printMatrix();
    }

    public void transposeHorizontal() {
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
        result.printMatrix();
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
            Matrix matrix = new Matrix(matrix1.getRow() - 1, matrix1.getColumn() - 1);
            for (int j = 1; j < matrix1.getRow(); j++) {
                for (int k = 0; k < matrix1.getColumn(); k++) {
                    if (k < i) {
                        matrix.setCoordination(j - 1, k, matrix1.getCoordination(j, k));
                    } else if (k > i) {
                        matrix.setCoordination(j - 1, k - 1, matrix1.getCoordination(j, k));
                    }
                }
                result += matrix1.getCoordination(0, i) * Math.pow(-1, i) * determinant(matrix);
            }
        }
        return result;
    }

    public void determinant() {
        System.out.println(determinant(matrixA));
    }
}
