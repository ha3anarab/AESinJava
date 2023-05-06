import java.security.MessageDigest;

public class Hashing {

    public String getHashCode(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
        byte[] digest = messageDigest.digest(messageInBytes);
        return StringUtil.encode(digest);
    }
}
