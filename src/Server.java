import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Server {

    //Possible T_LEN values are 128, 120, 112, 104 and 96
    private final int T_LEN = 128;
    private SecretKey key;
    private byte[] IV;

    public void init() throws Exception {
        KeyGenerator generator = KeyGenerator.getInstance("AES");

        //Possible KEY_SIZE values are 128, 192 and 256
        generator.init(128);
        key = generator.generateKey();

        Cipher encryptedCipher = Cipher.getInstance("AES/GCM/NoPadding");
        encryptedCipher.init(Cipher.ENCRYPT_MODE, key);
        IV = encryptedCipher.getIV();
    }

    public void initFromStrings(String secretKey, String IV) {
        key = new SecretKeySpec(StringUtil.decode(secretKey), "AES");
        this.IV = StringUtil.decode(IV);
    }

    public String encrypt(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        Cipher encryptedCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, IV);
        encryptedCipher.init(Cipher.ENCRYPT_MODE, key, spec);
        IV = encryptedCipher.getIV();
        byte[] encryptedMessageInByte = encryptedCipher.doFinal(messageInBytes);
        return StringUtil.encode(encryptedMessageInByte);
    }

    public void exportKeyAndIV() {
        System.err.println("SecretKey : " + StringUtil.encode(key.getEncoded()));
        System.err.println("IV : " + StringUtil.encode(IV));
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.initFromStrings("ofZ6Iu7QnZu55T9nosWnHQ", "MrQTDmL3estMPfoH");
            String encryptedText = server.encrypt("This is secret code");
            System.err.println("Encrypted Text : " + encryptedText);
        } catch (Exception ignored) {}
    }
}
