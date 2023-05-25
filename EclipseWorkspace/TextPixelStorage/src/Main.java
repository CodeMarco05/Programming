import java.nio.charset.StandardCharsets;

public class Main {

	public static void main(String[] args) {
        char ch = 'Ä';
        byte encodedByte = encodeToEightBits(ch);
        String binaryString = byteToBinaryString(encodedByte);
        System.out.println("Encoded byte value (binary): " + binaryString);
    }

    public static byte encodeToEightBits(char ch) {
        String character = Character.toString(ch);
        byte[] utf8Bytes = character.getBytes(StandardCharsets.UTF_8);
        byte encodedByte = (byte) (utf8Bytes[utf8Bytes.length - 1] & 0xFF);  // Extract least significant eight bits
        return encodedByte;
    }

    public static String byteToBinaryString(byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }

}
