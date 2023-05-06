import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

public class DigitalSignature {
    private KeyPair keyPair;
    private Signature signature;

    private byte[] sign;

    public void init() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        keyPair = keyPairGenerator.generateKeyPair();
    }

    public String signing(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        signature = Signature.getInstance("SHA256WithRSA");
        signature.initSign(keyPair.getPrivate());
        signature.update(messageInBytes);
        sign = signature.sign();
        return StringUtil.encode(sign);
    }

    public Boolean verification(String signedMessage) throws Exception {
        byte[] messageInBytes = signedMessage.getBytes();
        signature.initVerify(keyPair.getPublic());
        signature.update(messageInBytes);
        return signature.verify(sign);
    }
}
