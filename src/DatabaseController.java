import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DatabaseController {

    public static String[] getAllNames(){

        int i = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
            while((reader.readLine()) != null){
                i++;
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        String[] database = new String[i];
        String[] names = new String[((int)i/2)];
        i = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
            String line;
            while((line = reader.readLine()) != null){
                i++;
                database[i-1] = line;
                if(i%2 == 1){
                    names[((int)((i-1)/2))] = line;
                }
            }
            reader.close();;
        }catch (IOException e2){
            e2.printStackTrace();
        }

        return names;
        
    }

    public static void saveAcc(Account acc){

        int i = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
            while((reader.readLine()) != null){
                i++;
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        String[] database = new String[i+2];
        i = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
            String line;
            while((line = reader.readLine()) != null){
                database[i] = line;
                i++;
            }
            reader.close();;
        }catch (IOException e2){
            e2.printStackTrace();
        }

        String [] newAcc = Account.getAccInfo(acc);
        database[i] = newAcc[0];
        database[i+1] = newAcc[1];

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt"));
            for(int j = 0; j < database.length; j++){
                writer.write(database[j]+"\n");
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void updateBalance(Account acc){

        int i = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
            while((reader.readLine()) != null){
                i++;
            }
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        String[] database = new String[i];
        i = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
            String line;
            while((line = reader.readLine()) != null){
                database[i] = line;
                i++;
            }
            reader.close();;
        }catch (IOException e2){
            e2.printStackTrace();
        }

        String [] newAcc = Account.getAccInfo(acc);
        
        for(int j = 0; j < database.length; j=j+2){
            if(database[j].equals(newAcc[0])){
                database[j+1] = newAcc[1];
            }
        }

        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt"));
            for(int j = 0; j < database.length; j++){
                writer.write(database[j]+"\n");
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
