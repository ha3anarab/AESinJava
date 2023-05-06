public class Main {
    public static void main(String[] args) {

        //SymmetricEncryption
        try {
            SymmetricEncryption symmetricEncryption = new SymmetricEncryption();
            symmetricEncryption.init();
            String encryptedText = symmetricEncryption.encrypt("This is secret code");
            String decryptedText = symmetricEncryption.decrypt(encryptedText);

            System.err.println(" Symmetric Encrypted Text : " + encryptedText);
            System.err.println(" Symmetric Decrypted Text : " + decryptedText);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        //ASymmetricEncryption
        try {
            ASymmetricEncryption aSymmetric = new ASymmetricEncryption();
            aSymmetric.init();
            String encryptedText = aSymmetric.encrypt("This is secret code");
            String decryptedText = aSymmetric.decrypt(encryptedText);

            System.err.println(" ASymmetric Encrypted Text : " + encryptedText);
            System.err.println(" ASymmetric Decrypted Text : " + decryptedText);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}