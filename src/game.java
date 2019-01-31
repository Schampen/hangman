import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {

        String word = getWord();

        char[] wordd = new char[word.length()];
        char[] antal = new char[word.length()];

        for (int i = 0 ; i < word.length() ; i++) {
            wordd[i] = word.charAt(i);
            antal[i] = '_';
        }

        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Courier New", Font.BOLD, 18)));

        String[] stage = stage();

        int s = 0;
        char gissning;
        String word2 = new String(antal);
        int ok = 0;

        int chars = word.length();
        ArrayList<Character> used = new ArrayList<>();
        ArrayList<Character> wrong = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "Hangman Game 2.0");
        JOptionPane.showMessageDialog(null, "The word contains " + chars + " characters");

        while (ok == 0) {
            gissning = guess(word, wordd, antal, JOptionPane.showInputDialog(null, stage[s] + "\n" + word2 + "\n" + "Wrong guesses == " + wrong + "\n\nGuess a character"), used);
            String gis = "" + gissning;
            if (!word.contains(gis)) {
                if (!wrong.contains(gissning)){
                    wrong.add(gissning);
                    s = s + 1;
                }
            }
            word2 = new String(antal);

            used.add(gissning);
            if (word2.equals(word)){
                ok = 1;
                JOptionPane.showMessageDialog(null, "You guessed right, the word was " + word + ", congratulations!");
            } if (s == 9){
                JOptionPane.showMessageDialog(null, "You have no more guesses left, sad. \nThe word was " + word);
                break;
            }
        }

    }

    private static char guess(String word, char[] wordd, char[] antal, String s, ArrayList<Character> used) {
        char gissning;
        gissning = s.charAt(0);
        for (int i = 0 ; i < word.length() ; i++) {
            if (used.contains(gissning)) {
                JOptionPane.showMessageDialog(null, "This character has already been guessed");
                break;
            }
            if (gissning == wordd[i]) {
                antal[i] = wordd[i];
            }
        }
        return gissning;
    }

    private static String getWord() {
        Random rand = new Random();
        File file = new File("words.txt");
        int n = rand.nextInt(500);
        Scanner fileInput = null;

        try {
            fileInput = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> possibleWords = new ArrayList<>();
        while (fileInput.hasNextLine()){
            possibleWords.add(fileInput.nextLine());
        }

        String[] wordsPossible = new String[possibleWords.size()];
        for (int i = 0 ; i < possibleWords.size() ; i++)  {
            wordsPossible[i] = possibleWords.get(i);
        }
        String word = wordsPossible[n];
        return word;
    }

    private static String[] stage() {
        return new String[]{
                "       \n" +
                        "       \n" +
                        "       \n" +
                        "       \n" +
                        "       \n" +
                        "       \n" +
                        "=========" ,
                "       \n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========" ,
                "    --+\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========" ,
                "  +---+\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========" ,
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========" ,
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        "  |   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========" ,
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|   |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========" ,
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        "      |\n" +
                        "      |\n" +
                        "=========" ,
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " /    |\n" +
                        "      |\n" +
                        "=========" ,
                "  +---+\n" +
                        "  |   |\n" +
                        "  O   |\n" +
                        " /|\\  |\n" +
                        " / \\  |\n" +
                        "      |\n" +
                        "========="
        };
    }
}
