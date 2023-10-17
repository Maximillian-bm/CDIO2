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
        UI ui;

        //Importing scanner
        var scanner = new java.util.Scanner(System.in);
        scanner.useLocale(java.util.Locale.ENGLISH);
        String input;

        System.out.println("Welcome to the DIE game\nFor Danish write 'danish'\nFor English write 'english'");

        while(scanner.hasNextLine()) {

            input = scanner.nextLine();
            
            //select luangedge laungide languige langridge luangrich..... vælg et sprog
            if(firstRun){

                if(input.equals("danish")){
                    ui = new UI(1);
                }else{
                    ui = new UI(0);
                }

                //Replace with UI method
                System.out.println("control instruktions for acc selection");
            }

            if(input.equals("start") && !firstRun){
                if(p1ready && p2ready){
                    start = true;
                }
            }
            gameLoop:
            if(start && !firstRun){
                //if both player have selected an acc and they have written start this code will run

            }else if(!firstRun){
                //if not both players have selected an acc yet this code wil run

                accSelection:
                if(input.equals("switch")){
                    //TOO DO if someone wants to switch acc

                    //replace with ui method
                    System.out.println("both players now dont have an acc selected so player 1 select an acc");

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
                            //replace with ui method
                            System.out.println("name is already in use by player 2 one you stupid bitch write another name");
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
                        //replace with ui method
                        System.out.println("player 1 has selected acc now its player 2's turn bla bla bla");

                    }else if(!p2ready){
                        
                        if(player1.getAcc() != null && input.equals(player1.getName())){
                            //replace with ui method
                            System.out.println("name is already in use by player 1 one you stupid bitch write another name");
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
                        //replace with ui method
                        System.out.println("player 2 has selected acc you can now start the game bla bla bla");

                    }

                }

            }
            if(firstRun){
                firstRun = false;
            }
            
        }

        scanner.close();
 
    }
}
