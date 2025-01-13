/*# Problem Statement: Odd-Even Sorting

The file `input-for-odd-even-sorting.txt` contains a sequence of at least two and at most \(10^6\) natural numbers from the interval [0, 10^3], separated by a space. The sequence has at least one even number and at least one odd number. The task is to display the terms of the sequence on the screen, separated by a space, in such a way that all odd numbers appear before all even numbers. Additionally, both the subsequence of odd numbers and the subsequence of even numbers should be in ascending order, as shown in the example.

Design an efficient algorithm in terms of execution time.

 Example:
If the file contains the numbers `12 2 3 1 2 5`, the output should be:  
1 3 5 2 2 12


 */

 import java.io.*;
 import java.util.*;
 
 public class OddEvenSorter {
     public static void main(String[] args) {
         
         String fileName = "input-for-odd-even-sorting.txt";
 
         try {
             
             List<Integer> numbers = readNumbersFromFile(fileName);
 
             
             List<Integer> oddNumbers = new ArrayList<>();
             List<Integer> evenNumbers = new ArrayList<>();
             
             for (int num : numbers) {
                 if (num % 2 == 0) {
                     evenNumbers.add(num);  
                 } else {
                     oddNumbers.add(num);   
                 }
             }
 
            
             Collections.sort(oddNumbers);  
             Collections.sort(evenNumbers);  
 
           
             List<Integer> sortedNumbers = new ArrayList<>();
             sortedNumbers.addAll(oddNumbers);
             sortedNumbers.addAll(evenNumbers);
 
             
             System.out.println("Sorted sequence: ");
             for (int num : sortedNumbers) {
                 System.out.print(num + " ");
             }
 
         } catch (IOException e) {
             System.err.println("Error reading the file: " + e.getMessage());
         }
     }
 
     
     public static List<Integer> readNumbersFromFile(String fileName) throws IOException {
         BufferedReader reader = new BufferedReader(new FileReader(fileName));
         List<Integer> numbers = new ArrayList<>();
 
         String line;
         while ((line = reader.readLine()) != null) {
             String[] tokens = line.split("\\s+"); 
             for (String token : tokens) {
                 numbers.add(Integer.parseInt(token)); 
             }
         }
 
         reader.close();
         return numbers;
     }
 }
 