package ObjectSorting;
import java.util.*;
public class StringSplitExample {
    public static void main(String[] args) {
        // Example string to tokenize
        String inputString = "Java is a programming language";

        // Using split method
        String[] tokens = inputString.split(" ");

        // Iterating through tokens
        for (String token : tokens) {
            System.out.println("Token: " + token);
        }
    }
}

