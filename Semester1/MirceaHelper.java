/*Statement:
Mircea is passionate about programming. He started solving increasingly difficult problems. Thus, he reached a problem where the input consists of a square array with \( n \) rows and \( n \) columns, with all the elements of the array being distinct natural numbers from 1 to \( n^2 \). To test the program he wrote, he needs a file containing this array. After he created this file, his brother, in a playful mood, tampered with the file and swapped some consecutive numbers with the number 0. When Mircea returned from playing, he was shocked to find that his program didn't work for that test. After a few hours of debugging, he realizes that his program is correct and that the input file is the problem.

 Task:
Write a program that helps Mircea by finding the smallest and the largest of the consecutive numbers swapped by his brother with the number 0.
 */
import java.util.HashSet;

public class MirceaHelper {

    
    public static int[] findSwappedNumbers(int[][] matrix, int n) {
        HashSet<Integer> presentNumbers = new HashSet<>();
        
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    presentNumbers.add(matrix[i][j]);
                }
            }
        }

       
        int maxNumber = n * n; 
        HashSet<Integer> missingNumbers = new HashSet<>();
        
        
        for (int i = 1; i <= maxNumber; i++) {
            if (!presentNumbers.contains(i)) {
                missingNumbers.add(i);
            }
        }
        
     
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int num : missingNumbers) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        
        return new int[]{min, max};  
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
            {5, 0, 7},
            {0, 0, 1},
            {6, 9, 8}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        
        int[] result = findSwappedNumbers(matrix, 3);
        System.out.println("\nThe smallest swapped number is: " + result[0]);
        System.out.println("The largest swapped number is: " + result[1]);
    }
}
