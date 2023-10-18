public class UI {

    String[][] diceIndex = new String[6][7];
    String[] text;
    String[] englishText = {"This is a 2 player game, you will each have to create an account by writing the name you want your account to have or write one of the following names to sellect an existing account",
                            "There are no accounts saved in the database",
                            "You use you account to save how many gold pieces you have, you win gold by playing the game and it cost 1000 gold to play it but dont worry becous all new accounts start with 1000 gold. You can also switch account by writing 'switch'. When both players have selected an account you can write 'start' to start the game. Player one you are up first, write a name",
                            "player 1 has selected acc now its player 2's turn",
                            "player 2 has selected acc",
                            "name is already in use by player 2 one you stupid bitch write another name",
                            "name is already in use by player 1 one you stupid bitch write another name",
                            "both players now dont have an acc selected so player 1 start by selecting or creating an acc by writing a name",
                            "game rules and controlls"};
    String[] danishText = {"Hej"};
    String tiles = "-------------------------------------------------------------\n|  0 |+250|-100|+100| -20|+180|  0 | -70| +60|-80?| -50|+650|\n-------------------------------------------------------------";

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
        }else{
            text = englishText;
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

    public void printRoll(String name, int[] status){

        printDiceRoll(status);

        int sum = status[0] + status[1];

        System.out.println(name+text[sum+7]+status[2]);

    }
    
}
