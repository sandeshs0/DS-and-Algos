public class MatrixMul{

    public static int[][] multiply(int[][]matA, int[][] matB){

        int m= matA.length;
        int n= matB[0].length;
        int p=matB.length;

        int[][] result= new int[m][n];

        Thread[] threads= new Thread[m];

            for(int i=0;i<m;i++){
                final int row=i;
                threads[i]=new Thread(()->{
                    for(int j=0;j<n;j++){
                        int sum=0;
                        for(int k=0;k<p;k++){
                            sum+=matA[row][k]*matB[k][j];
                        }
                        result[row][j]=sum;
                    }
                });
                threads[i].start();
            }
    
        try{
          
            for(Thread th : threads){
                th.join();
            }
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
        return result;
    }

    public static void printMatrix(int[][]matrix){
        for(int[]row:matrix){
            for(int value:row){
                System.out.print(value+ " ");
            }
            System.out.println();
        }
    }

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

    printMatrix(multiply(matrixA, matrixB));
}
}