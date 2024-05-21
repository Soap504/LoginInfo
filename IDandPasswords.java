import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class IDandPasswords {
    
    private HashMap<String, String> loginInfo = new HashMap<String,String>();
    private final String outputPath = "importantData.txt";
    private SecretKey secretKey;
    IDandPasswords(){
         try {
            // Try to load the secret key from file
            byte[] keyBytes = Files.readAllBytes(Paths.get("secret.key"));
            secretKey = new SecretKeySpec(keyBytes, "AES");
        } catch (IOException e) {
            // If key file not found, generate a new key and save it
            try {
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(128);
                secretKey = keyGen.generateKey();
                Files.write(Paths.get("secret.key"), secretKey.getEncoded());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void setHashing(String key, String value){
        loginInfo.put(key,value);
    }

    public void sendToFile() {
        try (FileOutputStream fos = new FileOutputStream(outputPath);
             CipherOutputStream cos = new CipherOutputStream(fos, getCipher(Cipher.ENCRYPT_MODE))) {
            ObjectOutputStream oos = new ObjectOutputStream(cos);
            oos.writeObject(loginInfo);
            oos.flush();
            System.out.println("Hashmap has been written to: " + outputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile() {
        try (FileInputStream fis = new FileInputStream(outputPath);
             CipherInputStream cis = new CipherInputStream(fis, getCipher(Cipher.DECRYPT_MODE))) {
            ObjectInputStream ois = new ObjectInputStream(cis);
            loginInfo = (HashMap<String, String>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Cipher getCipher(int mode) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(mode, secretKey);
        return cipher;
    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }
    
}
