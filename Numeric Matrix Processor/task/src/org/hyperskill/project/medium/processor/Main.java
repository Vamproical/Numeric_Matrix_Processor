package org.hyperskill.project.medium.processor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowA = scanner.nextInt();
        int columnA = scanner.nextInt();
        int[][] matrixA = new int[rowA][columnA];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }
        int rowB = scanner.nextInt();
        int columnB = scanner.nextInt();
        int[][] matrixB = new int[rowB][columnB];
        for (int i = 0; i < rowB; i++) {
            for (int j = 0; j < columnB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }
        if (rowA != rowB || columnA != columnB) {
            System.out.println("ERROR");
        }
        else {
            int[][] matrixC = new int[rowA][columnA];
            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < columnB; j++) {
                    matrixC[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
            for (int i = 0; i < rowB; i++) {
                for (int j = 0; j < columnB; j++) {
                    System.out.print(matrixC[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
