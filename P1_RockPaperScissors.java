import java.util.Random;

public class P1_RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int wins = 0, losses = 0, draws = 0;
        int rounds = 5;

        System.out.printf("%-6s %-15s %-15s %-15s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------------");

        for (int i = 1; i <= rounds; i++) {
            String playerMove = moves[random.nextInt(moves.length)];
            String computerMove = moves[random.nextInt(moves.length)];
            String result = playRound(playerMove, computerMove);

            System.out.printf("%-6d %-15s %-15s %-15s%n", i, playerMove, computerMove, result);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }

        double winPercentage = (wins * 100.0) / rounds;
        System.out.println("\nFinal Summary (after " + rounds + " rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
    }
}