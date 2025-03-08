package com.example.paint.assets;

public class Matrix {
    public static double[][] multiply(double[][] A, double[][] B) {
        int m = A.length;      // Rows in A
        int n = A[0].length;   // Columns in A (must match rows in B)
        int p = B[0].length;   // Columns in B

        if (n != B.length) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication.");
        }

        double[][] result = new double[m][p];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    public static double[] multiply(double[] A, double[][] B) {
        int m = A.length;      // Columns in A (must match rows in B)
        int n = B[0].length;   // Columns in B

        if (m != B.length) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication.");
        }

        double[] result = new double[n];

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < m; k++) {
                result[j] += A[k] * B[k][j];
            }
        }
        return result;
    }
}
