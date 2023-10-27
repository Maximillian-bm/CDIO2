class TestDieMod {
    public static void main(String[] args){

        Die[] d = new Die[15];

        d[0] = new Die(1);
        d[1] = new Die(2);
        d[2] = new Die(3);
        d[3] = new Die(4);
        d[4] = new Die(5);
        d[5] = new Die(6);
        d[6] = new Die(7);
        d[7] = new Die(8);
        d[8] = new Die(9);
        d[9] = new Die(10);
        d[10] = new Die(11);
        d[11] = new Die(12);
        d[12] = new Die(13);
        d[13] = new Die(14);
        d[14] = new Die(15);

        for(int i = 0; i < 15; i++){
            System.out.println("");
            System.out.println("printing 10 rolls with a die with "+i+" sides");
            for(int j = 0; j < 10; j++){
                System.out.println(d[i].rollDie());
            }
        }
    }
}