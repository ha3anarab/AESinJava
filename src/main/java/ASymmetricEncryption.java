import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class ASymmetricEncryption {

    private KeyPair keyPair;
    private Cipher cipher;


    public void init() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        keyPair = keyPairGenerator.generateKeyPair();
    }

    public String encrypt(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());
        byte[] encryptedMessage = cipher.doFinal(messageInBytes);
        return StringUtil.encode(encryptedMessage);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] messageInBytes = StringUtil.decode(encryptedMessage);
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());
        byte[] decryptedMessage = cipher.doFinal(messageInBytes);
        return new String(decryptedMessage);
    }
}
