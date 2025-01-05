/*Write a program that reads a non-zero natural number n with at most 4 digits and determines the smallest prime number greater than n */
import java.util.Scanner;

public class Main {

    
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter a natural number (with at most 4 digits): ");
        int n = scanner.nextInt();

       
        int number = n + 1;
        while (!isPrime(number)) {
            number++;
        }

        System.out.println("The smallest prime number greater than " + n + " is " + number);
    }
}
