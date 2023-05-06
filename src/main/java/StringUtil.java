import java.util.Base64;

public class StringUtil {
    public static String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

    public static byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public static void printWithSize(String textForPrint, String result) {
        System.err.println(textForPrint + " : " + result);
        System.err.println(textForPrint + "Size : " + decode(result).length * 8 + " bits");
    }
}
