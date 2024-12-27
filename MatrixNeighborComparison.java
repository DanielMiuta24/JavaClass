public class MatrixNeighborComparison {
    public static int NeighborComparison  (int[][]matrix1) {
        
       
    int k=0;
      for(int i=0; i<matrix1.length; i++) {
        for(int j=0; j<matrix1.length; j++) {
            if(matrix1[i][j]>matrix1[i][j+1] && matrix1[i][j]>matrix1[i][j-1] )
                k++;
        }
        System.out.println();
      }
     return k;
    }

    public static void main(String[] args) {
        int[][] A = {
            {1,5,1,1},
            {2,1,2,3},
            {1,3,4,2},
            {2,1,2,1}
      
        };
        int result = NeighborComparison(A);

        // Output the result
        System.out.println("Number of elements: " + result);

    }


}