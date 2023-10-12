/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package encryptionrsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Arrays;
import javax.crypto.Cipher;

/**
 *
 * @author Alois
 */
public class EncryptionRSA {

    
    
    public static void main(String[] args) throws Exception{
        // generate key pair using KeyPairGenerator
         KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
         keyPairGenerator.initialize(2048); // bit key size
         
         KeyPair keyPair = keyPairGenerator.generateKeyPair();
         
         
         //instanciate the Cipher class
         Cipher rsaCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
         
         
         //Encrypt data
         rsaCipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic()); //initialise the cipher object on a encrypt mode passing the public key
         System.out.println("\nThis is the public Key \n"+keyPair.getPublic());
         
         String text = "\nThe sky is blue\n"; //message to be encrypted
         System.out.println("\nMessage to be encrypted"+text);
         
         byte[] plainText = text.getBytes();// get the bytes of the string
         System.out.println("\nBytes of the message to be encrypted \n"+Arrays.toString(plainText));//////
         
         byte[] cipherText = rsaCipher.doFinal(plainText);//apply the Cipher to encrypt the bytes from
         System.out.println("\nThis is the encrypted message\n"+Arrays.toString(cipherText));//////
         
         //Decrypt data 
         rsaCipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());// initialise the cipher on a decypt mode passing the private key
          System.out.println("\nThis is the private Key \n"+keyPair.getPrivate());//////
         byte[] decryptedText = rsaCipher.doFinal(cipherText);
         
         System.out.println(decryptedText);
         
    }
    
}
