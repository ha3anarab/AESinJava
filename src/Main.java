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

            System.err.println("\n" + " ASymmetric Encrypted Text : " + encryptedText);
            System.err.println(" ASymmetric Decrypted Text : " + decryptedText);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        //DigitalSignature
        try {
            DigitalSignature digitalSignature = new DigitalSignature();
            digitalSignature.init();
            String encryptedText = digitalSignature.signing("I signed this text");
            System.err.println("\n" + " Signed Text : " + encryptedText);

            Boolean isVerified = digitalSignature.verification("I signed this text"); //return TRUE, cuz sign(text) is identical
            System.err.println(" isVerified : " + isVerified);

            isVerified = digitalSignature.verification("I 'NOT' signed this text"); //return FALSE, cuz sign(text) is not the same
            System.err.println(" isVerified : " + isVerified);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}