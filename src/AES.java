import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class AES {
    private SecretKey key;
    private Cipher encryptedCipher;
    private final StringUtil stringUtil = new StringUtil();

    public void init() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");

        //Possible KEY_SIZE values are 128, 192 and 256
        generator.init(128);

        key = generator.generateKey();
    }

    public String encrypt(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        encryptedCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptedCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedMessageInByte = encryptedCipher.doFinal(messageInBytes);
        return stringUtil.encode(encryptedMessageInByte);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] messageInBytes = stringUtil.decode(encryptedMessage);
        Cipher decryptCipher = Cipher.getInstance("AES/GCM/NoPadding");

        //Possible tLEN values are 128, 120, 112, 104 and 96
        GCMParameterSpec spec = new GCMParameterSpec(128, encryptedCipher.getIV());

        decryptCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptCipher.doFinal(messageInBytes);
        return new String(decryptedBytes);
    }
}
