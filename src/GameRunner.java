public class GameRunner {
    public String input;

    public static void main(String[] args) throws Exception {
        //Creating player objects
        Player player1 = new Player();
        Player player2 = new Player();
        
        //Creating DatabaseController
        DatabaseController dataC = new DatabaseController(); 

        //Importing scanner
        var scanner = new java.util.Scanner(System.in);
        scanner.useLocale(java.util.Locale.ENGLISH);
        String input;

        while(scanner.hasNextLine()) {
            input = scanner.nextLine();
            
        }
 
    }
}
