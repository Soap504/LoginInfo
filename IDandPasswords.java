import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class IDandPasswords {
    Scanner lookFor = new Scanner(System.in);
    HashMap<String, String> loginInfo = new HashMap<String,String>();
    String outputPath = "importantData.txt";

    IDandPasswords(){
        loginInfo.put("admin", "password");
    }

    @SuppressWarnings("rawtypes")
    protected HashMap setHashing(String key, String value){
        loginInfo.put(key,value);
        return null;
    }

    protected void sendToFile() throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))){
            for(Entry<String, String> entry : loginInfo.entrySet()){
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

        System.out.println("Hashmap has been written to: " + outputPath);
    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }
    
}
