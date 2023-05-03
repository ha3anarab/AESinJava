import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Client {

    //Possible T_LEN values are 128, 120, 112, 104 and 96
    private SecretKey key;
    private final int T_LEN = 128;
    private byte[] IV;

    public void initFromStrings(String secretKey, String IV) {
        key = new SecretKeySpec(StringUtil.decode(secretKey), "AES");
        this.IV = StringUtil.decode(IV);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] messageInBytes = StringUtil.decode(encryptedMessage);
        Cipher decryptionCipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec spec = new GCMParameterSpec(T_LEN, IV);
        decryptionCipher.init(Cipher.DECRYPT_MODE, key, spec);
        byte[] decryptedBytes = decryptionCipher.doFinal(messageInBytes);
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.initFromStrings("ofZ6Iu7QnZu55T9nosWnHQ", "MrQTDmL3estMPfoH");
            String decryptedMessage = client.decrypt("16kdggT5xXjXXIhJxD3Ei93ag/SEU88ldGMU66v9TGUiAlA=");
            System.err.println("Decrypted Message : " + decryptedMessage);
        } catch (Exception ignored) {}
    }
}
