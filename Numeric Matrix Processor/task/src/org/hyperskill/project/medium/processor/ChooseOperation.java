package org.hyperskill.project.medium.processor;

import java.util.Scanner;

public class ChooseOperation {
    private final Scanner scanner = new Scanner(System.in);

    public void choose() {
        boolean flag = false;
        while (!flag) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix to a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("0. Exit");
            System.out.println("Your choice: ");
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    System.out.println("Enter size of first matrix: ");
                    int rowAForAdd = scanner.nextInt();
                    int columnAForAdd = scanner.nextInt();
                    Matrix matrixAForAdd = new Matrix(rowAForAdd, columnAForAdd);
                    System.out.println("Enter first matrix: ");
                    matrixAForAdd.enterMatrix();
                    System.out.println("Enter size of second matrix: ");
                    int rowBForAdd = scanner.nextInt();
                    int columnBForAdd = scanner.nextInt();
                    Matrix matrixBForAdd = new Matrix(rowBForAdd, columnBForAdd);
                    System.out.println("Enter second matrix: ");
                    matrixBForAdd.enterMatrix();
                    if (rowAForAdd != rowBForAdd || columnAForAdd != columnBForAdd) {
                        System.out.println("ERROR");
                    } else {
                        OperationOnMatrix operationOnMatrix = new OperationOnMatrix(matrixAForAdd, matrixBForAdd);
                        operationOnMatrix.addMatrix();
                    }
                    break;
                case 2:
                    System.out.println("Enter size of the matrix: ");
                    int row = scanner.nextInt();
                    int column = scanner.nextInt();
                    Matrix matrix = new Matrix(row, column);
                    System.out.println("Enter the matrix: ");
                    matrix.enterMatrix();
                    System.out.println("Enter the constant: ");
                    double constant = scanner.nextInt();
                    OperationOnMatrix operationOnMatrix = new OperationOnMatrix(matrix);
                    operationOnMatrix.multiplyConstant(constant);
                    break;
                case 3:
                    System.out.println("Enter size of first matrix: ");
                    int rowAForMultiply = scanner.nextInt();
                    int columnAForMultiply = scanner.nextInt();
                    Matrix matrixAForMultiply = new Matrix(rowAForMultiply, columnAForMultiply);
                    System.out.println("Enter first matrix: ");
                    matrixAForMultiply.enterMatrix();
                    System.out.println("Enter size of second matrix: ");
                    int rowBForMultiply = scanner.nextInt();
                    int columnBForMultiply = scanner.nextInt();
                    Matrix matrixBForMultiply = new Matrix(rowBForMultiply, columnBForMultiply);
                    System.out.println("Enter second matrix: ");
                    matrixBForMultiply.enterMatrix();
                    if (columnAForMultiply != rowBForMultiply) {
                        System.out.println("ERROR");
                    } else {
                        OperationOnMatrix operationOnMatrix1 = new OperationOnMatrix(matrixAForMultiply, matrixBForMultiply);
                        operationOnMatrix1.multiplyMatrices();
                    }
                    break;
                case 0:
                    flag = true;
                    break;
                default:
                    System.out.println("Incorrect operation");
                    break;
            }
        }
    }
}
