public class Starter {
    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.init();
            server.exportKeyAndIV();
            //Save "SecretKey" and "IV" for initFromString method
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
