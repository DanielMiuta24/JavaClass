import java.util.Arrays;

public class MatrixSorter {

    
    public static void sortRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
        }
    }

    
    public static void sortColumns(int[][] matrix) {
        int n = matrix.length;
        
        for (int j = 0; j < n; j++) {
           
            int[] column = new int[n];
            
            
            for (int i = 0; i < n; i++) {
                column[i] = matrix[i][j];
            }

            
            Arrays.sort(column);

           
            for (int i = 0; i < n; i++) {
                matrix[i][j] = column[i];
            }
        }
    }

    
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {9, 3, 6},
            {2, 8, 4},
            {7, 5, 1}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix);

       
        sortRows(matrix);

        System.out.println("\nMatrix after sorting rows:");
        printMatrix(matrix);

        
        sortColumns(matrix);

        System.out.println("\nMatrix after sorting columns:");
        printMatrix(matrix);
    }
}
