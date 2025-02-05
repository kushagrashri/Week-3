// Import HashSet to store unique characters
import java.util.HashSet;

public class RemoveDuplicate {
    public static void main(String[] args) {
        // Input string with duplicate characters
        String str = "Duugggguuu";

        // StringBuilder to store the result without duplicates
        StringBuilder sb = new StringBuilder();

        // HashSet to track characters that have already been added
        HashSet<Character> hs = new HashSet<>();

        // Iterate over each character in the string
        for (char ch : str.toCharArray()) {
            // If the character is not already in the HashSet, add it to StringBuilder
            if (!hs.contains(ch)) {
                sb.append(ch);
            }
            // Add the character to the HashSet to mark it as seen
            hs.add(ch);
        }

        // Print the string after removing duplicates
        System.out.println("String after removing duplicates: " + sb.toString());
    }
}
