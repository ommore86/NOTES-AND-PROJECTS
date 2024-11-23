import java.util.*;

public class WordGuessingGame {
    public static void main(String[] args) {
        String[] words = {"India", "USA", "Canada", "Brazil", "Germany", "Australia", "Japan", "Russia", "China", "France"};
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)]; 
        char[] guessedWord = new char[wordToGuess.length()]; 

        Arrays.fill(guessedWord, '_');

        int attempts = 6; 
        Set<Character> guessedLetters = new HashSet<>();

        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Guess the country name. You have " + attempts + " attempts.");

        Scanner scanner = new Scanner(System.in);

        while (attempts > 0) {
            StringBuilder displayWord = new StringBuilder();
            for (int i = 0; i < wordToGuess.length(); i++) {
                displayWord.append(guessedWord[i]).append(" ");
            }
            System.out.println("\nWord: " + displayWord.toString().trim());

            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter!");
                continue;
            }

            guessedLetters.add(guess);

            boolean correctGuess = false;

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (Character.toLowerCase(wordToGuess.charAt(i)) == guess) {
                    guessedWord[i] = wordToGuess.charAt(i);
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                System.out.println("Correct guess!");

                String currentWord = new String(guessedWord);
                if (currentWord.equals(wordToGuess)) {
                    System.out.println("Congratulations! You guessed the word: " + wordToGuess);
                    break;
                }
            } else {
                attempts--;
                System.out.println("Wrong guess! Attempts left: " + attempts);
            }
        }

        if (attempts == 0) {
            System.out.println("Game over! The word was: " + wordToGuess);
        }

        scanner.close();
    }
}