/*A matrix with integer elements is given. 
The task is to determine the arithmetic mean of the strictly positive
 elements in the matrix that are located below the main diagonal. */
public class MatrixArithmeticMean {

    public static double calculateMean(int[][] matrix) {
        int sum = 0;
        int count = 0;
        int n = matrix.length;

        // Traverse the elements below the main diagonal
        for (int i = 1; i < n; i++) {  // Start from row 1 (below the main diagonal)
            for (int j = 0; j < i; j++) {  // j < i ensures we're below the main diagonal
                if (matrix[i][j] > 0) {
                    sum += matrix[i][j];
                    count++;
                }
            }
        }

        // If there are no positive elements, return 0
        if (count == 0) {
            return 0;
        }

        // Return the arithmetic mean
        return (double) sum / count;
    }

    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {
            {1, -2, 3},
            {4, 5, -6},
            {7, 8, 9}
        };

        // Calculate the arithmetic mean of the positive elements below the main diagonal
        double result = calculateMean(matrix);

        // Output the result
        System.out.println("The arithmetic mean of the strictly positive elements below the main diagonal is: " + result);
        
    }
}
