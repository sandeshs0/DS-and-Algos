public class ParallelMatrixMultiplier {

    public static void main(String[] args) {
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] matrixB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int[][] result = multiply(matrixA, matrixB);
        printMatrix(result);
    }

    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int m = matrixA.length;
        int n = matrixB[0].length;
        int p = matrixB.length;
        int[][] result = new int[m][n];

        Thread[] threads = new Thread[m];
        for (int i = 0; i < m; i++) {
            final int row = i;
            threads[i] = new Thread(() -> {
                for (int j = 0; j < n; j++) {
                    int sum = 0;
                    for (int k = 0; k < p; k++) {
                        sum += matrixA[row][k] * matrixB[k][j];
                    }
                    result[row][j] = sum;
                }
            });
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
