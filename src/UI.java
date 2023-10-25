public class UI {

    private String[][] diceIndex = new String[6][7];
    private String[] text;
    private final String[] englishText = {"This is a 2 player game, you will each have to create an account by writing the name you want your account to have or write one of the following names to sellect an existing account",
                            "There are no accounts saved in the database",
                            "You use you account to save how many gold pieces you have, you win gold by playing the game and it cost 1000 gold to play it but dont worry becous all new accounts start with 1000 gold. You can also switch account by writing 'switch'. You can write 'exit' to exit the program. When both players have selected an account you can write 'start' to start the game. Player one you are up first, write a name",
                            "player 1 has selected acc now its player 2's turn",
                            "player 2 has selected acc you can now start the game by writig 'start'",
                            "name is already in use by player 2 one you stupid bitch write another name",
                            "name is already in use by player 1 one you stupid bitch write another name",
                            "both players now dont have an acc selected so player 1 start by selecting or creating an acc by writing a name",
                            " How to roll, to roll the dice you have to type 'roll' in the console. The game requires 2 dice in order to play. The two players alternate turns to roll unless they roll a 10, then they get an extra roll. The sum of each roll has a value which determines how much gold is added or subtracted to your balance. List of rollvalues(2. Tower +250, 3. Crater -100, 4. Palace gates +100, 5. Cold Desert -20, 6. Walled city +180, 7. Monastery 0, 8. Black cave -70, 9. Huts in the mountain +60, 10. The Werewall (werewolf-wall) -80,  11. The pit -50, 12. Goldmine +650)  ",
                            " you have rolled a 2, You've discovered a majestic Tower! 250 gold coins magically appear in your pockets, giving you a grand total of...) ",
                            " you have rolled a 3, Oh no! You stumbled into a Crater! 100 gold coins vanish into thin air, leaving you with a total of...",
                            " you have rolled a 4, You've arrived at the regal Palace Gates! 100 gold coins graciously bestowed upon you, boosting your total to...",
                            " you have rolled a 5, Brr, it's the Cold Desert! 20 gold coins drift away like grains of sand, leaving you with...",
                            " you have rolled a 6, Welcome to the bustling Walled City! Your new friends in the city are quite hospitable, and they've chipped in, gifting you with 180 gold coins to raise your total to...",
                            " you have rolled a 7, You've reached the serene Monastery, you find inner peace and remain at...",
                            " you have rolled an 8, You stare into the Black Cave! 70 gold coins disappear into the darkness, leaving you with...",
                            " you have rolled a 9, You've discovered a cozy Huts in the Mountain!y You find 60 gold coins in the hut, giving you...",
                            " you have rolled a 10, Uh-oh, you've hit the Werewall, and it's a howler! You lost 80 gold coins, but you get an extra turn, and your new total is...",
                            " you have rolled an 11, You narrowly avoid the Pit, but 50 gold coins fall out of your pocket into the abyss, leaving you with... ",
                            " you have rolled a 12, You struck gold at the Goldmine! +650 gold coins, and your total now stands at...",
                            " Congratulations, you've emerged as the ultimate gold hunter, amassing a treasure trove of 3,000 gold coins! You stand triumphant, your fortune glittering like a dragon's hoard, and the title of champion is yours to claim!",
                            " You dont have enough money to play",
                            " you have won!!! you now have an account ballance of ",
                            " you fucking looser youve lost and have now an account balance of ",
                            "This gama is now done you can write 'start' to start a new game or write 'switch' to use other accounts"};
    private final String[] danishText = {"Dette er et 2-spiller spil, I skal hver især oprette en konto ved at skrive det navn, du ønsker din konto skal have, eller skrive et af følgende navne for at vælge en eksisterende konto.",
                            "Der er ingen konti gemt i databasen.",
                            "Du bruger din konto til at gemme, hvor mange guldmønter du har. Du vinder guld ved at spille spillet, og det koster 1000 guld at spille det, men fortvivl ikke, for alle nye konti starter med 1000 guld. Du kan også skifte konto ved at skrive 'skift'. Skriv 'stop' for at stoppe spillet. Når begge spillere har valgt en konto, kan I skrive 'start' for at begynde spillet. Spiller et, det er din tur. Skriv et navn.",
                            "Spiller 1 har valgt en konto, nu er det spiller 2's tur.",
                            "Spiller 2 har valgt en konto. nu kan spillet startes ved at skrive 'start'",
                            "Navnet er allerede i brug af spiller 2. Skriv et andet navn, din tåbelige person.",
                            "Navnet er allerede i brug af spiller 1. Skriv et andet navn, din tåbelige person.",
                            "Begge spillere har nu ikke en konto, så spiller 1 begynder ved at vælge eller oprette en konto ved at skrive et navn.",
                            "Sådan ruller du terningerne: Du skal skrive 'kast' i konsollen for at rulle terningerne. Spillet kræver 2 terninger for at spille. De to spillere skiftes til at rulle, medmindre de ruller en 10, hvorefter de får et ekstra rulle. Summen af hver rulle har en værdi, hvlike afgør, hvor meget guld der tilføjes eller trækkes fra din saldo. Liste over terningværdier (2. Tårn +250, 3. Krater -100, 4. Palas port +100, 5. Kold ørken -20, 6. Muret by +180, 7. Kloster 0, 8. Sorte hule -70, 9. Hytter i bjergene +60, 10. Varulvevæg -80, 11. Hullet -50, 12. Guldmine +650)..",
                            " Du har slået en 2, Du har opdaget et majestætisk tårn! 250 guld mønter dukker magisk op i dine lommer og giver dig en samlet sum af...",
                            " Du har slået en 3, Åh nej! Du er faldet ned i en krater! 100 guld mønter forsvinder som dug for solen og efterlader dig med en samlet sum af...",
                            " Du har slået en 4. Du er ankommet til porten af det royale palads! De er gavmilde i dag og giver dig 100 guld mønter, hvilket bringer din samlede sum til...",
                            " Du har slået en 5. Brr, det er den Kolde Ørken! Dine guld mønter besluttede sig at tage på deres eget eventyr, og 20 af dem svævede bare væk som sandkorn. Nu har du...",
                            " Du har slået en 6. Velkommen til den travle by med mure! Dine nye venner i byen er ganske gæstfri, og de har lagt 180 guld mønter i puljen for at øge din samlede sum til...",
                            " Du har slået en 7. Du er nået det fredelige kloster. Du finder indre ro, men dit guld forbliver i en zen-lignende tilstand af...",
                            " Du har slået en 8. Du stirrer ned i dybet af den sorte hule! 70 guld mønter er blevet slugt af mørket, og din samlede sum er nu...",
                            " Du har slået en 9. Du er stødt på hyggelige hytter i bjergene! I en af hytterne opdager du 60 guld mønter, hvilket bringer din samlede sum til...",
                            " Du har slået en 10. Åh nej, du har ramt warulve-muren, og den hyler i gennem hele natten! Du mister 80 guld mønter, men du får en ekstra tur, så din nye sum er...",
                            " Du har slået en 11. Du undgik heldigvis hullet, men 50 guld mønter faldt ned i afgrunden og efterlod dig med...",
                            " Du har slået en 12. Du har ramt guldåren i guldminen! +650 guld mønter er regnet ned over dig, og din samlede sum står nu på...",
                            " Du er nået enden af din rejse, og med en imponerende mængde af 3.000 guld mønter i lommen, er du den uovertrufne guldjæger. Guld strømmer mod dig, og du bader i din nyfundne rigdom.",
                            " Du har ikke nogle penge til at spille",
                            " du har vundet!!! du har nu en konto balance på ",
                            " din fucking taber du har tabt og har nu en konto balance på ",
                            "Spillet er nu slut, du kan skrive 'start' for at starte et nyt spil eller skrive 'skift' for at bruger andre kontoer"};
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

    public void showResults(Player w, Player l){

        String[] wInfo = Account.getAccInfo(w.getAcc());
        String[] lInfo = Account.getAccInfo(l.getAcc());

        System.out.println(wInfo[0]+text[22]+wInfo[1]);
        System.out.println(lInfo[0]+text[23]+lInfo[1]);

        System.out.println(text[24]);

    }
    
}
