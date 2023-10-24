import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        printLongestWord(sentence);
        printPangramStatus(sentence);
    }

    public static void printLongestWord(String sentence) {
        String[] words = sentence.split(" ");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println("Longest word: " + longestWord);
    }

    public static void printPangramStatus(String sentence) {
        boolean[] lettersPresent = new boolean[26];
        int missingLetters = 26;

        sentence = sentence.toLowerCase();

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c >= 'a' && c <= 'z' && !lettersPresent[c - 'a']) {
                lettersPresent[c - 'a'] = true;
                missingLetters--;
            }
        }

        if (missingLetters == 0) {
            System.out.println("Pangram");
        } else {
            System.out.println("Not Pangram");
        }
    }
}
