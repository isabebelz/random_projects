package crypto;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSAEncryptor {

    RSAKeyGenerator rsaKey = new RSAKeyGenerator();

    public String encrypt(String text) {

        try {

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            cipher.init(Cipher.ENCRYPT_MODE, rsaKey.getPublicKey());

            byte[] textBytes = text.getBytes("UTF-8");

            byte[] encryptedBytes = cipher.doFinal(textBytes);

            return Base64.getEncoder().encodeToString(encryptedBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }


    }

    public String encrypt(String text, PublicKey publicKey) {

        try {

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] textBytes = text.getBytes("UTF-8");

            byte[] encryptedBytes = cipher.doFinal(textBytes);

            return Base64.getEncoder().encodeToString(encryptedBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }


    }

    public String decrypt(String encryptedText) {

        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

            cipher.init(Cipher.DECRYPT_MODE, rsaKey.getPrivateKey());

            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            return new String(decryptedBytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
