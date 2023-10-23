public class Player {

    private Die dice1 = new Die(6);
    private Die dice2 = new Die(6);

    private int points; 

    private Account acc;

    public void newAcc(String name){
        acc = new Account(name);
    }

    public void pullAcc(String name){
        acc = DatabaseController.pullAccFromDB(name);
    }

    public Account getAcc(){
        return acc;
    }

    public void resetAcc(){
        acc = null;
    }

    public String getName(){
        String[] temp = Account.getAccInfo(acc);
        return temp[0];
    }

    public int[] rollDice() {
        int x = dice1.rollDie();
        int y = dice2.rollDie(); 

        int roll = x + y; 

        if (roll == 2) {
            points = points+250; 
        } else if (roll == 3) {
            points = points-100;
        } else if (roll == 4) {
            points = points+100;
        } else if (roll == 5) {
            points = points-20;
        } else if (roll == 6) {
            points = points+180;
        } else if (roll == 7) {
            points = points+0; 
        } else if (roll == 8) {
            points = points-70; 
        } else if (roll == 9) {
            points = points+60; 
        } else if (roll == 10) {
            points = points-80; 
        } else if (roll == 11) {
            points = points-50;
        } else if (roll == 12) {
            points = points+650; 
        }
        int[] r = {x,y,points};
        return r; 
    }

    public boolean addPoints(int p) {
        if(acc.withdraw(p)){
            points = points+p;
            return true;
        }else{
            return false;
        }
    }

    public int empty() {
        int temporary; 
        temporary = points; 
        points = 0; 

        return temporary; 
    }

    public boolean hasWon(){
        
        if(3000 <= points){
            return true;
        }else{
            return false;
        }
    }
}