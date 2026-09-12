public class P5_GuessTheNumberGame {
    public static void guessTheNumber(int secretNumber, int maxTries, int[] guesses) {
        int tryCounter = 0;
        boolean guessed = false;

        while (tryCounter < maxTries && tryCounter < guesses.length && !guessed) {
            int guess = guesses[tryCounter];
            if (guess < secretNumber) {
                System.out.println("Too low");
            } else if (guess > secretNumber) {
                System.out.println("Too high");
            } else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }
            tryCounter++;
        }

        if (!guessed) {
            System.out.println("Out of tries — the number was " + secretNumber);
        }
    }

    public static void main(String[] args) {
        guessTheNumber(42, 4, new int[]{20, 60, 42});
        System.out.println();
        guessTheNumber(42, 2, new int[]{10, 15});
    }
}