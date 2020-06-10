package org.hyperskill.project.medium.processor;

import java.util.Scanner;

public class Matrix {
    private final Scanner scanner = new Scanner(System.in);
    private final int row, column;
    private final double[][] matrix;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        matrix = new double[row][column];
    }

    public void enterMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.printf("%.2f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double getCoordination(int i, int j) {
        return matrix[i][j];
    }

    public void setCoordination(int i, int j, double value) {
        matrix[i][j] = value;
    }
}
