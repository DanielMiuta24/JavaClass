/*A sentence is given that contains only lowercase letters of the English alphabet and spaces. Display the words from the sentence that contain only vowels. */
public class VowelWords {

    
    public static boolean containsOnlyVowels(String word) {
        
        String vowels = "aeiou";
        
        
        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) == -1) {
                
                return false;
            }
        }
        
        return true;
    }

    
    public static void printVowelWords(String sentence) {
        
        String[] words = sentence.split(" ");
        
        
        for (String word : words) {
            
            if (containsOnlyVowels(word)) {
                
                System.out.println(word);
            }
        }
    }

    public static void main(String[] args) {
        
        String sentence = "aei oei e ai";
        
       
        System.out.println("The words that contain only vowels are:");
        printVowelWords(sentence);
    }
}
