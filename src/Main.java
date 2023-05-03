
public class Main {
    public static void main(String[] args) {
        try {
            AES aes = new AES();
            aes.init();
            String encryptedText = aes.encrypt("This is secret code");
            String decryptedText = aes.decrypt(encryptedText);

            System.err.println("Encrypted Text : " + encryptedText);
            System.err.println("Decrypted Text : " + decryptedText);
        }catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}