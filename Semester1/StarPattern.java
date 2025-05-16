public class StarPattern {
    public static void main(String[] args) {
        int n = 4;  

       
        for (int i = 1; i <= n; i++) {
           
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }

         
           
            int spaces = 2 * (i - 1)+1;
            if (spaces < 1) {
                spaces = 1;  
            }

           
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

          
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }

            System.out.println(); 
        }

      
        for (int i = n - 1; i >= 1; i--) {
          
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }

          
              
              int spaces = 2 * (i - 1)+1;
              if (spaces < 1) {
                  spaces = 1;  
              }
  
              
              for (int j = 1; j <= spaces; j++) {
                  System.out.print(" ");
              }
  
           
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }

            System.out.println(); 
        }
    }
}
