import org.junit.jupiter.api.Test;

class HashingTest {

    @Test
    void getHashCode() throws Exception {
        Hashing hashing = new Hashing();
        String hashCode = hashing.getHashCode("This is secret code");
        StringUtil.printWithSize(" Hash Text ", hashCode);
    }
}