public class Account {
    
    private String name;
    private int wallet;
    private final int startValue = 1000;

    public Account(String name){
        this.name = name;
        this.wallet = startValue;
    }

    public static String[] getAccInfo(Account acc){
        String[] temp = {acc.name, Integer.toString(acc.wallet)};
        return temp;
    }
}
