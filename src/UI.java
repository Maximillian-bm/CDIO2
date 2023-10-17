public class UI {

    String[][] diceIndex = new String[6][7];
    String[] text;
    String[] englishText = {"Hello"};
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
    
}
