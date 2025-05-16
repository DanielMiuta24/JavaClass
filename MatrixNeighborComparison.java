/*Write a program that reads a natural number n (1 ≤ n ≤ 20) 
from the keyboard and then the elements of a two-dimensional 
array with n rows and n columns, which stores natural numbers.

The program displays on the screen the number of elements in 
the array that are strictly greater than all the elements that 
are directly adjacent (on the same row but in an adjacent column, 
or on the same column but in an adjacent row). */

public class MatrixNeighborComparison {
    /**
     * @param matrix1
     * @return
     */
    public static int NeighborComparison(int[][] matrix) {
        int count = 0;
        int n = matrix.length;

        // Loop through the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isGreater = true; // Assume the current element is greater

                // Check the right neighbor (if exists)
                if (j + 1 < n && matrix[i][j] <= matrix[i][j + 1]) {
                    isGreater = false; // The current element is not greater than the right neighbor
                }

                // Check the left neighbor (if exists)
                if (j - 1 >= 0 && matrix[i][j] <= matrix[i][j - 1]) {
                    isGreater = false; // The current element is not greater than the left neighbor
                }

                // Check the bottom neighbor (if exists)
                if (i + 1 < n && matrix[i][j] <= matrix[i + 1][j]) {
                    isGreater = false; // The current element is not greater than the bottom neighbor
                }

                // Check the top neighbor (if exists)
                if (i - 1 >= 0 && matrix[i][j] <= matrix[i - 1][j]) {
                    isGreater = false; // The current element is not greater than the top neighbor
                }

                // If the current element is strictly greater than all its neighbors
                if (isGreater) {
                    count++;
                }
            }
        }

        return count;
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
        System.out.println("Number of elements which are strictly greater than their neighbors: " + result);

        
    }


}