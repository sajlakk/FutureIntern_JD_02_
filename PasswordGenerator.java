import java.util.Random;
import java.util.Scanner;


public class PasswordGenerator {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String SPECIAL_CHAR = "!@#$%^&*()_+";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.println("Generated Password : " + generatePassword(length));
    }

    private static String generatePassword(int length) {
        String password = "";
        Random random = new Random();

        // Combine all character types
        String combinedChar = CHAR_LOWER + CHAR_UPPER + NUMBER + SPECIAL_CHAR;

        // Ensure password contains at least one character from each type
        password += getRandomChar(CHAR_LOWER, random);
        password += getRandomChar(CHAR_UPPER, random);
        password += getRandomChar(NUMBER, random);
        password += getRandomChar(SPECIAL_CHAR, random);

        // Fill the rest of the password length
        for (int i = 4; i < length; i++) {
            password += getRandomChar(combinedChar, random);
        }

        // Shuffle the password to avoid the first characters always being in the same character type order
        password = shuffleString(password);

        return password;
    }

    private static char getRandomChar(String charStr, Random random) {
        return charStr.charAt(random.nextInt(charStr.length()));
    }

    private static String shuffleString(String str) {
        char[] arr = str.toCharArray();
        Random random = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            // Swap character at index with the last character
            char temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }

        return new String(arr);
    }
}
