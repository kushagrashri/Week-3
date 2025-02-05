// Program to reverse a string using StringBuilder
public class ReverseString {
    public static void main(String[] args) {
        // Initialize a string
        String str = "Hello";

        // Create a StringBuilder object
        StringBuilder builder = new StringBuilder();

        // Append the string to the StringBuilder
        builder.append(str);

        // Reverse the string using StringBuilder's reverse() method
        builder.reverse();

        // Convert the StringBuilder back to a string and print the reversed string
        System.out.println("Reversed String: " + builder.toString());
    }
}
