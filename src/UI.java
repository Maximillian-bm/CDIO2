public class UI {

    private String[][] diceIndex = new String[6][7];
    private String[] text;
    private final String[] englishText = {"This is a 2 player game, you will each have to create an account by writing the name you want your account to have or write one of the following names to sellect an existing account",
                            "There are no accounts saved in the database",
                            "You use you account to save how many gold pieces you have, you win gold by playing the game and it cost 1000 gold to play it but dont worry becous all new accounts start with 1000 gold. You can also switch account by writing 'switch'. You can write 'exit' to exit the program. When both players have selected an account you can write 'start' to start the game. Player one you are up first, write a name",
                            "player 1 has selected acc now its player 2's turn",
                            "player 2 has selected acc",
                            "name is already in use by player 2 one you stupid bitch write another name",
                            "name is already in use by player 1 one you stupid bitch write another name",
                            "both players now dont have an acc selected so player 1 start by selecting or creating an acc by writing a name",
                            "game rules and controlls",
                            " you have rolled a 2, you get 250 gold and now have a total of ",
                            " you have rolled a 3, you lose 100 gold and now have a total of ",
                            " you have rolled a 4, you get 100 gold and now have a total of ",
                            " you have rolled a 5, you lose 20 gold and now have a total of ",
                            " you have rolled a 6, you get 180 gold and now have a total of ",
                            " you have rolled a 7, you get no gold and now have a total of ",
                            " you have rolled an 8, you lose 70 gold and now have a total of ",
                            " you have rolled a 9, you get 60 gold and now have a total of ",
                            " you have rolled a 10, you lose 80 gold BUT you get an extra turn and you now have a total of ",
                            " you have rolled an 11, you lose 50 gold and now have a total of ",
                            " you have rolled a 12, you get 650 gold and now have a total of ",
                            " you have over 3000 gold and win",
                            "you dont have anoth gold broke bitch"};
    private final String[] danishText = {"Dette er et 2-spiller spil, I skal hver især oprette en konto ved at skrive det navn, du ønsker din konto skal have, eller skrive et af følgende navne for at vælge en eksisterende konto.",
                            "Der er ingen konti gemt i databasen.",
                            "Du bruger din konto til at gemme, hvor mange guldmønter du har. Du vinder guld ved at spille spillet, og det koster 1000 guld at spille det, men fortvivl ikke, for alle nye konti starter med 1000 guld. Du kan også skifte konto ved at skrive 'skift'. Skriv 'stop' for at stoppe spillet. Når begge spillere har valgt en konto, kan I skrive 'start' for at begynde spillet. Spiller et, det er din tur. Skriv et navn.",
                            "Spiller 1 har valgt en konto, nu er det spiller 2's tur.",
                            "Spiller 2 har valgt en konto.",
                            "Navnet er allerede i brug af spiller 2. Skriv et andet navn, din tåbelige person.",
                            "Navnet er allerede i brug af spiller 1. Skriv et andet navn, din tåbelige person.",
                            "Begge spillere har nu ikke valgt en konto, så spiller 1 begynder ved at vælge eller oprette en konto ved at skrive et navn.",
                            "Spilleregler og kontrol.",
                            " Du har slået en 2'er. Du får 250 guld og har nu i alt ",
                            " Du har slået en 3'er. Du mister 100 guld og har nu i alt ",
                            " Du har slået en 4'er. Du får 100 guld og har nu i alt ",
                            " Du har slået en 5'er. Du mister 20 guld og har nu i alt ",
                            " Du har slået en 6'er. Du får 180 guld og har nu i alt ",
                            " Du har slået en 7'er. Du får ingen guld og har nu i alt ",
                            " Du har slået en 8'er. Du mister 70 guld og har nu i alt ",
                            " Du har slået en 9'er. Du får 60 guld og har nu i alt ",
                            " Du har slået en 10'er. Du mister 80 guld, MEN får en ekstra tur, og har nu i alt ",
                            " Du har slået en 11'er. Du mister 50 guld og har nu i alt ",
                            " Du har slået en 12'er. Du får 650 guld og har nu i alt ",
                            " Du har over 3000 guld og vinder.",
                            "du har ik nok guld din fattigrøv"};
    private final String tiles = "-------------------------------------------------------------\n|  0 |+250|-100|+100| -20|+180|  0 | -70| +60|-80?| -50|+650|\n-------------------------------------------------------------";

    private String[] input;
    private final String[] danishInput = {"start", "kast", "skift", "stop"};
    private final String[] englishInput = {"start", "roll", "switch", "exit"};

    public UI(int x) {
        diceIndex[0][0] = "--------------";
        diceIndex[0][1] = "|            |";
        diceIndex[0][2] = "|            |";
        diceIndex[0][3] = "|     O      |";
        diceIndex[0][4] = "|            |";
        diceIndex[0][5] = "|            |";
        diceIndex[0][6] = "--------------";

        diceIndex[1][0] = "--------------";
        diceIndex[1][1] = "|  O         |";
        diceIndex[1][2] = "|            |";
        diceIndex[1][3] = "|            |";
        diceIndex[1][4] = "|            |";
        diceIndex[1][5] = "|         O  |";
        diceIndex[1][6] = "--------------";

        diceIndex[2][0] = "--------------";
        diceIndex[2][1] = "|  O         |";
        diceIndex[2][2] = "|            |";
        diceIndex[2][3] = "|     O      |";
        diceIndex[2][4] = "|            |";
        diceIndex[2][5] = "|         O  |";
        diceIndex[2][6] = "--------------";

        diceIndex[3][0] = "--------------";
        diceIndex[3][1] = "|  O      O  |";
        diceIndex[3][2] = "|            |";
        diceIndex[3][3] = "|            |";
        diceIndex[3][4] = "|            |";
        diceIndex[3][5] = "|  O      O  |";
        diceIndex[3][6] = "--------------";

        diceIndex[4][0] = "--------------";
        diceIndex[4][1] = "|  O      O  |";
        diceIndex[4][2] = "|            |";
        diceIndex[4][3] = "|     O      |";
        diceIndex[4][4] = "|            |";
        diceIndex[4][5] = "|  O      O  |";
        diceIndex[4][6] = "--------------";

        diceIndex[5][0] = "--------------";
        diceIndex[5][1] = "|   O    O   |";
        diceIndex[5][2] = "|            |";
        diceIndex[5][3] = "|   O    O   |";
        diceIndex[5][4] = "|            |";
        diceIndex[5][5] = "|   O    O   |";
        diceIndex[5][6] = "--------------";

        if(x == 1){
            text = danishText;
            input = danishInput;
        }else{
            text = englishText;
            input = englishInput;
        }
    }

    public void printDiceRoll(int[] diceRolls) {
        String output = "";
        String next = "\n";
        String space = "        ";

        for (int i = 0; i < 7; i++) {
            output = output + this.diceIndex[(diceRolls[0] - 1)][i] + space + this.diceIndex[(diceRolls[1] - 1)][i] + next;
        }

        System.out.println(output);
        System.out.println(tiles);

        int sum = diceRolls[0]+diceRolls[1];
        int bar = sum*5-1;
        int t = 10;

        for(int i = 0; i < bar;i++){
            t = (int)1000/(bar-i);
            try {
                Thread.sleep(t);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("■");
        }
    }

    public void print(int x){

        System.out.println(text[x]);

        if(x == 0){

            String[] names = DatabaseController.getAllNames();

            if(names.length == 0){

                System.out.println(text[1]);

            }else{

                for(int i = 0; i < names.length; i++){

                    System.out.println(names[i]);

                }
            }

            System.out.println(text[2]);
        }

    }

    public boolean is(String input, int i){
        return this.input[i].equals(input);
    }

    public void printRoll(String name, int[] status){

        printDiceRoll(status);

        int sum = status[0] + status[1];

        System.out.println();
        System.out.println(name+text[sum+7]+status[2]);

    }
    
}
