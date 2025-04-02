import java.io.IOException;
import java.security.*;
import java.util.Base64;
import javax.crypto.*;

public class DES {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException {
        
        String message = "kill him tomorrow.";
        byte[] myMessage = message.getBytes();
        
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        SecretKey desKey = keyGenerator.generateKey();
        
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, desKey);
        
        byte[] encryptedBytes = cipher.doFinal(myMessage);
        
        String encryptedData = Base64.getEncoder().encodeToString(encryptedBytes);
        
        cipher.init(Cipher.DECRYPT_MODE, desKey);
        
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedData = new String(decryptedBytes);
        
        System.out.println("Original Message: " + message);
        System.out.println("Encrypted Message : " + encryptedData);
        System.out.println("Decrypted Message: " + decryptedData);
    }
}
