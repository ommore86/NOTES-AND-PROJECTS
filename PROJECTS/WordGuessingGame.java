import java.util.*;

public class WordGuessingGame {
    public static void main(String[] args) {
        // countries
        String[] words = {"India", "USA", "Canada", "Brazil", "Germany", "Australia", "Japan", "Russia", "China", "France"};
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)]; // Randomly select a word
        char[] guessedWord = new char[wordToGuess.length()];  // No spaces, just underscores

        // Initialize guessedWord with underscores
        Arrays.fill(guessedWord, '_');

        int attempts = 6; // Number of attempts
        Set<Character> guessedLetters = new HashSet<>();

        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Guess the country name. You have " + attempts + " attempts.");

        Scanner scanner = new Scanner(System.in);

        while (attempts > 0) {
            // Display the word with spaces between underscores
            StringBuilder displayWord = new StringBuilder();
            for (int i = 0; i < wordToGuess.length(); i++) {
                displayWord.append(guessedWord[i]).append(" ");
            }
            System.out.println("\nWord: " + displayWord.toString().trim());

            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            // Check if the letter was already guessed
            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter!");
                continue;
            }

            guessedLetters.add(guess);

            boolean correctGuess = false;

            // Loop through the word to find all occurrences of the guessed letter
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (Character.toLowerCase(wordToGuess.charAt(i)) == guess) {
                    guessedWord[i] = wordToGuess.charAt(i);  // Update guessed word with correct letter
                    correctGuess = true;
                }
            }

            // If the guess was correct
            if (correctGuess) {
                System.out.println("Correct guess!");

                // Check if the player has guessed the word
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