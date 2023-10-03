package crypto;

import java.security.*;

public class RSAKeyGenerator {

    KeyPair keyPair;

    public RSAKeyGenerator() {
        keyPair = generateKeyPair();
    }

    KeyPair generateKeyPair() {

        try {

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

            keyPairGenerator.initialize(2048);

            return keyPairGenerator.generateKeyPair();

        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
            return null;

        }

    }

    public PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }

}


