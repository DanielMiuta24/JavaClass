public class DotProduct {

    // Method to calculate dot product
    public static int calculateDotProduct(int[] vector1, int[] vector2) {
        // Ensure the vectors have the same length
        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("Vectors must have the same length");
        }

        int dotProduct = 0;
        // Loop through the vectors and calculate the sum of products of corresponding elements
        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
        }
        return dotProduct;
    }

    public static void main(String[] args) {
        // Example vectors
        int[] vector1 = {1, 2, 3};
        int[] vector2 = {4, 5, 6};

        // Calculate the dot product
        int result = calculateDotProduct(vector1, vector2);

        // Output the result
        System.out.println("The dot product of the vectors is: " + result);
    }
}
