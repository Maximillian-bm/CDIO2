public class GameRunner {
    public String input;

    public static void main(String[] args) throws Exception {
        //Creating player objects
        Player player1 = new Player();
        Player player2 = new Player();

        boolean start = false;
        boolean p1ready = false;
        boolean p2ready = false;
        boolean firstRun = true;
        boolean firstGameRun = true;
        boolean p1sTurn = true;
        UI ui = new UI(0);

        //Importing scanner
        var scanner = new java.util.Scanner(System.in);
        scanner.useLocale(java.util.Locale.ENGLISH);
        String input;

        System.out.println("Welcome to the DIE game\nFor Danish write 'danish'\nFor English write 'english'");

        program:
        while(scanner.hasNextLine()) {

            input = scanner.nextLine();
            
            //select luangedge laungide languige langridge luangrich..... vælg et sprog
            if(firstRun){

                if(input.equals("danish")){
                    ui = new UI(1);
                }else{
                    ui = new UI(0);
                }

                ui.print(0);
            }

            if(ui.is(input, 0)){
                if(p1ready && p2ready){
                    start = true;
                }
            }

            if(start){
                //if both player have selected an acc and they have written start this code will run

                if(firstGameRun){

                    if(player1.addPoints(1000)&&player2.addPoints(1000)){
                        ui.print(8);
                        firstGameRun = false;
                    }else{
                        ui.print(20);
                        ui.print(7);
                        player1.resetAcc();
                        player2.resetAcc();
                        p1ready = false;
                        p2ready = false;
                        start = false;
                    }
                    
                }

                if(ui.is(input, 1)){

                    if(p1sTurn){

                        int[] roll = player1.rollDice();

                        ui.printRoll(player1.getName(), roll);

                        if(roll[0] + roll[1] != 10){
                            p1sTurn = false;
                        }

                    }else{

                        int[] roll = player2.rollDice();

                        ui.printRoll(player2.getName(), roll);

                        if(roll[0] + roll[1] != 10){
                            p1sTurn = true;
                        }

                    }
                }

                if(player1.hasWon()){
                    //TO DOO add text in ui
                    System.out.println("player 1 won");
                    endGame(player1, player2);
                    start = false;

                }else if(player2.hasWon()){
                    //TO DOO add text in ui
                    System.out.println("player 2 won");
                    endGame(player1, player2);
                    start = false;
                    
                }

            }else if(!firstRun){
                //if not both players have selected an acc yet this code wil run

                accSelection:
                if(ui.is(input, 2)){

                    ui.print(7);

                    player1.resetAcc();
                    player2.resetAcc();
                    start = false;
                    p1ready = false;
                    p2ready = false;

                }else{
                    //players have put in a name so we check if the name already exist

                    String[] names = DatabaseController.getAllNames();

                    if(!p1ready){

                        if(player2.getAcc() != null && input.equals(player2.getName())){
                            ui.print(5);
                            break accSelection;
                        }

                        for(int i = 0; i < names.length; i++){
                            if(names[i].equals(input)){
                                player1.pullAcc(input);
                                p1ready = true;
                            }
                        }

                        if(!p1ready){
                            player1.newAcc(input);
                            p1ready = true;
                        }
                        ui.print(3);

                    }else if(!p2ready){
                        
                        if(player1.getAcc() != null && input.equals(player1.getName())){
                           ui.print(6);
                            break accSelection;
                        }

                        for(int i = 0; i < names.length; i++){
                            if(names[i].equals(input)){
                                player2.pullAcc(input);
                                p2ready = true;
                            }
                        }

                        if(!p2ready){
                            player2.newAcc(input);
                            p2ready = true;
                        }
                        ui.print(4);

                    }

                }

            }
            if(firstRun){
                firstRun = false;
            }

            if(ui.is(input, 3)){
                break program;
            }
            
        }

        scanner.close();
 
    }

    static void endGame(Player p1, Player p2){
        p1.empty();
        p2.empty();
        if(DatabaseController.doesExist(p1.getAcc())){
            DatabaseController.updateBalance(p1.getAcc());
        }else{
            DatabaseController.saveAcc(p1.getAcc());
        }
        if(DatabaseController.doesExist(p2.getAcc())){
            DatabaseController.updateBalance(p2.getAcc());
        }else{
            DatabaseController.saveAcc(p2.getAcc());
        }
    }
}